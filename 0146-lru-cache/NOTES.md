> LRU Cache 구현

링크드 리스트와 해시 맵을 같이 사용해서 시간 복잡도를 줄일 수 있다  
탐색, 삽입, 삭제를 위해 O(n)을 써야 하는 걸 O(1)로 할 수 있다

캐시 교체 알고리즘
- LRU(Least Recently Used): 가장 오랫동안 사용되지 않은 캐시를 교체
- LFU(Least Frequently Used): 가장 사용 횟수가 적은 캐시를 교체

시간복잡도: O(1), 공간복잡도: O(capacity)​
