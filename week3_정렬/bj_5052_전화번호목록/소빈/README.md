## 전화번호 목록

- 구현시간: 미상, Trie 구조 코드 참고

- 자료구조: 트라이(Trie)

> 단점: 트라이노드들의 집합이라 차지하는 메모리가 크다.
> 장점: 탐색시간이 짧다는 장점이 있다.

- 주요로직: 탐색 트리 트라이를 활용하여 하나의 트라이를 생성한 후, 입력받은 전화번호를 하나씩 확인한다.

```
Map<Key, Value> map = new HashMap();
Value value = map.computIfAbsent(key, k -> getNewValue(key));
```
위와 같은 코드는 Map을 사용할 때 빈번하게 사용하는 코드 패턴인 아래의 코드를 짧게 구현한 모양이다.

```
Map<Key, Value> map = new HashMap();

Value value = map.get(key);
if(value == null){
	value = getNewValue(Key);
	map.put(key, value);
}
```

`computeIfAbsent(key, c->new TrieNode())` Key에 해당하는 Value가 존재하면 가져와서 사용하고 없으면 새로 만든다.

