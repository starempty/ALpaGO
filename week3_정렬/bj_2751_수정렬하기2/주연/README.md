# 2750 번 - 수 정렬하기 1 & 2

풀이시간: 5분

## 접근 방법

두 문제 모두 N의 수가 그리 많지는 않아, ArrayList로 저장 후 `Collections.sort`를 통해 해결하였습니다.

`Collections.sort`는 Tim 정렬을 사용하고 있습니다.

Tim 정렬은 삽입(Insertion) 정렬과 합병(Merge) 정렬을 결합하여 만든 정렬이며,  
Tim Sort 알고리즘의 최선 시간 복잡도는 O(n), 평균은 O(nlogn), 최악의 경우는 O(nlogn)입니다.

따라서, 입력으로 받는 수로 1초 이내에 연산이 가능합니다.

출력 되는 수가 많아, `StringBuilder`를 통하여 시간을 단축하였습니다.
