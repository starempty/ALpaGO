# 컬러볼


풀이시간: 시간초과

확인해야하는 공의 개수가 200,000이므로 이중포문으로 하나의 공을 기준으로 다른 공을 모두 확인하면 N\*N이 걸려 시간초과가 자명하다.

- 해결방법(O(N))

  구해야하는 공의 합이 기준 공보다 사이즈가 작고, 색이 같지 않아야한다.

  `(작은공AND색이다른공) = 작은공 - 색 같은 공`

  이와같은 집합 원리를 이용하여 코드를 작성했다.
![Untitled](https://user-images.githubusercontent.com/40350280/124233773-2800b880-db4e-11eb-8837-426cdbf03ade.png)

- 주요로직

  ```java
  int[] ans = new int[n];
  		int[] size = new int[n+1];
  		int total = 0;
  		int j = 0;
  		for(int i = 0; i < n; i++) {
  			while(sets[i].s > sets[j].s) {
  				total+= sets[j].s;
  				size[sets[j].c] += sets[j].s;
  				j++;
  			}
  			ans[sets[i].idx] = total- size[sets[i].c];
  		}
  ```

  `size`에는 색깔별 크기 누적합이 저장되고 `total` 변수에는 누적합이 저장된다.

  따라서 `ans` 배열에 `total - size[기준 공 색]` 를 기준공의 고유한 인덱스에 저장하면 출력하기 용이하다.

- 풀이후기

  조건이 여러개인 경우 집합로직을 이용하면 직관적으로 식을 작성할 수 있다는 것을 알게되었습니다.
