package com.project.pulleymath.domain.problem


import com.project.pulleymath.domain.problem.enums.Level
import com.project.pulleymath.domain.problem.enums.Type
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import com.project.pulleymath.domain.problem.rqrs.ProblemListRs
import com.project.pulleymath.domain.problem.rqrs.ProblemRs

@Service
@Transactional(readOnly = true)
class ProblemService(
    private val problemRepository: ProblemRepository
) {
    /**
     * 파라미터 별 문제를 추출하는 함수
     */
    fun searchProblem(totalCount: Long, unitCodeSnList: List<Long>, level: Level, problemType: Type): ProblemListRs {

        val problemList: MutableList<ProblemRs> = problemRepository.findByUnitCode(unitCodeSnList, problemType)

        // 만약 총 개수보다 가져온 데이터가 작다면, 가져온 데이터 개수만큼 Level 비율을 맞추기 위해 총 개수를 가져온 데이터 수로 변경한다.
        val totalCount = if (problemList.size <= totalCount) { problemList.size.toLong() } else { totalCount }

        // 난이도 비율별로 데이터를 추출한다.
        val filteredProblems = this.filterProblemsByLevelRatio(problemList, totalCount, level)

        return ProblemListRs.createProblemListRs(filteredProblems)
    }














    /**
     * 난이도 비율별로 문제들을 가져오게 하는 함수
     *
     * 참고.
     * - 총 개수의 비율별로 계산이 되지 않을 경우, 소수점 제외 후 가져온 다음 남은 데이터에서 총 개수 데이터 만큼 채운다.
     * - 해당 난이도에서 비율별로 데이터가 없다면, 나머지 난이도의 비율별로 가져온 후 남은 데이터에서 총 개수 데이터 만큼 채운다.
     */
    private fun filterProblemsByLevelRatio(problemList: MutableList<ProblemRs>, totalCount: Long, level: Level): MutableList<ProblemRs> {

        // 필터링된 결과를 담을 리스트 선언
        val filteredProblems = mutableListOf<ProblemRs>()
        // 난이도 별 구할 순서를 가져온다.
        val levelOrder: List<Level> = Level.getLevelsForOrder(level)

        // 만약 총 개수가 1일 시 비율을 맞출 수 없어 해당 난이도를 가져오도록 한다.
        if (totalCount == 1L) {
            filteredProblems.addAll(problemList.filter { it.level in level.levels}.take(totalCount.toInt()))
        } else {
            // 난이도별 순서대로 for 문을 통해 해당하는 level을 가져오고, 해당하는 비율의 개수만큼 return 에 담고,
            // 원본 데이터에서 담은 데이터를 삭제 후 다음 난이도의 비율별로 개수를 계산하여 가져오도록 진행한다. (총 3번 -> 상, 중, 하)
            levelOrder.forEachIndexed { index, v ->
                val processProblemList = problemList.filter { it.level in v.levels }
                    .take((totalCount * level.ratio[index]).toInt())
                    .toMutableList()
                // 결과값 담는다.
                filteredProblems.addAll(processProblemList)
                // 원본데이터에서 결과값 담은 데이터는 삭제한다.
                problemList.removeAll(processProblemList)
                // 다음 난이도 별 문제를 추출하기 위해 해당 리스트를 비워준다.
                processProblemList.clear()
            }
        }

        // 만약 비율대로 넣었을때, 총 개수만큼 넣어지지 않았다면, ( EX) 총 개수 10 -> lowProblem 이 데이터가 부족하여 5개를 못가져왔다면)
        if (filteredProblems.size <= totalCount) {
            // 못채운 수만큼 남은 데이터(문제)에서 총 개수 수만큼 채워 넣는다.
            val remainCount: Int = totalCount.toInt() - filteredProblems.size
            filteredProblems.addAll(problemList.take(remainCount))
        }

        return filteredProblems
    }

//
//    @Transactional
//    fun saveCategory(categoryRqList: List<CategoryRq>) {
//        val entityList = ArrayList<Category>()
//        val categoryMap = HashMap<Long, CategoryRq>()
//
//        categoryRqList.forEach { rq ->
//            // 만약 카테고리 sn이 있다면,
//            if (rq.sn != null) {
//                // 수정이므로 한번에 조회 할 수 있도록 snList를 따로 빼고, Map으로 변경될 내용들을 저장한다.
//                categoryMap[rq.sn] = rq
//            }
//            else {
//                // 생성 시 이름이 없을 시 Exception 발생
//                if (rq.name.isNullOrEmpty()) throw CommonException(CommonExceptionCode.NO_CATEGORY_NAME)
//                // sn 없다면, 신규 저장이므로 생성 후 저장한다.
//                entityList.add(Category.createCategory(rq))
//            }
//        }
//
//        // Map이 비워있지 않다면, 수정할 값이 있다고 판단한다.
//        if (!categoryMap.isNullOrEmpty()) {
//            // 한번에 조회 할 수 있도록 List로 담고, 조회 후 엔티티들을 가져온다.
//            val snList: List<Long> = categoryMap.keys.toList()
//            val categoryEntities: List<Category> = categoryRepository.findBySnIn(snList)
//            // 가져온 엔티티들을 돌려 미리 Map으로 rq를 담아놓은걸을 매칭하여 해당하는 sn을 통해 update 한다.
//            categoryEntities.forEach { category ->
//                if (categoryMap.containsKey(category.sn)) {
//                    entityList.add(category.updateCategory(categoryMap[category.sn]!!))
//                }
//            }
//        }
//
//        // 생성/수정 된 엔티티들을 저장/수정 한다.
//        categoryRepository.saveAll(entityList)
//    }
//
//    @Transactional
//    fun deleteCategory(snList: List<Long>) {
//        categoryRepository.deleteBySnList(snList)
//    }
}