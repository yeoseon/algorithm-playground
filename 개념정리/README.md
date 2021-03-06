# 시간 복잡도과 공간복잡도  

https://github.com/yeoseon/tip-archive/issues/260 참고  

# 빅오 표기법  (Big O notation)  

알고리즘이 얼마나 빠른지 표시하는 방법  

**실행시간이 얼마나 걸리는 지만 고려할 것이 아니라, 리스트가 증가할 때 어떻게 증가하는 지를 파악하기 위해 사용한다.**  

* 알고리즘이 동작하기 위해 필요한 연산 횟수를 비교하기 위한 표기법  
* 입력 데이터의 크기가 늘어날 때 알고리즘의 실행 속도가 얼마나 증가하는 지 알 수 있다.  
* O(log n)는 O(n)보다 빠르고, 찾으려는 원소의 개수가 증가하면 상대적으로 더 빨라진다.  
* 최악(worst case)의 경우에 대한 값이다.  
    - 단순 탐색은 O(n)인데, 1번만에 찾았다고 해서 O(1)이 아니라는 것  


**대표적인 5개의 빅오 실행 시간**  
* ###### O(log n), 로그시간 : 예) 이진탐색  
* O(n), 선형시간 : 예) 단순탐색
* O(n * log n) : 예) 선택 정렬과 같이 느린 정렬 알고리즘  
* O(n!) : 예) 많이 느린 알고리즘  

# 해시 알고리즘  

https://github.com/yeoseon/tip-archive/issues/261 참고  

## 해시 함수

문자열을 받아서 숫자를 반환한다.  
O(1)  
필요한 값이 있을 시 탐색할 필요 없이, 해당 Key 값을 통해 바로 찾을 수 있도록  

### 특징 

* 같은 이름에 대해서는 항상 같은 인덱스를 할당한다.  
* 다른 문자열에 대해서는 다른 인덱스를 할당한다.  
* 배열이 얼마나 큰 지 알고 있어야 하며, 유효한 인덱스만 반환해야 한다.  

## 해시 테이블

* 해시함수와 배열을 합치면 **해시 테이블**이라고 하는 자료구조를 얻을 수 있다.  
* 해시 테이블은 해시 함수를 사용해서 더 총명하게 어디에 원소를 저장할 지 결정한다.  
* 빠른 속도 (배열을 사용하기 때문에)  
* Key-Value를 가진다.  

### 예시 
* 해시테이블로 조회하기 (전화번호부)  
* 중복된 항목을 방지하기  
    * Key-Value가 들어오면 해당 Key를 통해 해당 Value가 이미 있는지 검사
* 해시테이블을 캐시로 사용하기  
    * 브라우저를 통해 페이지에 방문할 때마다 서버는 먼저 해시테이블에 저장된 페이지가 있는지 확인한다.  

### 충돌  

* 서로 다른 키를 배열의 서로 다른 위치에 저장하기란 쉽지 않다.  
* 이미 공간을 차지하고 있는데, 값을 넣는 것을 **충돌**이라고 한다.  

**해결 방법**  

* 같은 공간에 여러 개의 키를 연결 리스트로 만들어 넣기  
    * 연결리스트를 뒤져야 하므로 찾는데 시간이 더 걸린다.  
    * 다른 공간은 낭비된다. 결국 연결리스트를 이용하는 꼴  

**해시의 조건**  
* 해시 함수는 키를 해시테이블 전체에 고르게 할당해야 한다.  
* 연결 리스트가 길어지면 해시 테이블의 속도도 느려진다. 하지만 좋은 해시 함수가 있다면 그런 일은 발생하지 않는다.  

**충돌을 피하기 위해 필요한 것**   
* 낮은 사용률 / 좋은 해시함수  

**좋은 해시함수란?**  
* 배열에 값을 고루 분포시키는 함수


# 스택과 큐  

[Java에서의 스택과 큐](https://github.com/yeoseon/tip-archive/issues/97) 참고  

# 힙  

> **우선순위 큐를 위하여 만들어진 구조**  

## 우선순위 큐

우선순위의 개념을 큐에 도입한 자료구조.  
* 데이터들이 우선순위를 가지고 있고, 우선순위가 높은 데이터가 먼저 나간다.  


![자료구조별 삭제 요소](https://user-images.githubusercontent.com/54384004/74102676-18fc1d80-4b89-11ea-826c-c094f4db69ed.png)  

* 이용사례  
    * 시뮬레이션 시스템  
    * 네트워크의 트래픽 제어  
    * 운영체제에서의 작업 스케줄링  
    * 수치 해석적인 계산  

* 우선순위 큐는 배열, 연결리스트, 힙 으로 구현이 가능하다. 이 중에서 힙(heap)으로 구현하는 것이 가장 효율적이다.  
![우선순위 큐 빅오](https://user-images.githubusercontent.com/54384004/74102701-5eb8e600-4b89-11ea-8435-f53ba7fd7b4e.png)


## 자료구조 '힙'(Heap)

* **완전 이진트리의 일종**  
* 우선순위 큐를 위하여 만들어진 구조  
* 여러 개의 값들 중 최댓값이나 최솟값을 빠르게 구할 수 있도록 만들어진 구조  
* 일종의 반정렬 상태(느슨한 정렬 상태)를 유지한다.  
    * 큰 값이 상위 레벨에 있고 작은 값이 하위 레벨에 있다.  
    * 부모 노드의 값이 자식 노드의 값보다 항상 큰(작은) 이진트리.  
* 중복된 값을 허용한다.(이진탐색 트리에서는 허용하지 않음)  

## 힙의 종류  

* 최대 힙(max heap)  
    * 부모 노드의 키 값이 자식 노드의 키 값보다 크거나 같은 완전 이진트리   
* 최소 힙(min heap)
    * 부모 노드의 키 값이 자식 노드의 키 값보다 작거나 같은 완전 이진트리   
![최대 힙과 최소 힙](https://user-images.githubusercontent.com/54384004/74102753-eb63a400-4b89-11ea-8c9b-983430c90ef5.png)  

## 힙의 구현  

* 힙을 저장하는 표준적인 자료구조는 **배열** 이다.  
* 구현을 쉽게 하기 위해 배열의 첫번째 인덱스인 0은 사용하지 않는다.  
* 특정 위치의 노드 번호는 새로운 노드가 추가되어도 변하지 않는다.  
    * 루트 노드의 오른쪽 노드의 번호는 항상 3이다.  
* 힙에서의 부모 노드와 자식 노드의 관계  
    * 왼쪽 자식의 인덱스 = (부모의 인덱스) * 2  
    * 오른쪽 자식의 인덱스 = (부모의 인덱스) * 2 + 1  
    * 부모의 인덱스 = (자식의 인덱스) / 2  

![힙 부모 자식 관계](https://user-images.githubusercontent.com/54384004/74102792-409fb580-4b8a-11ea-97bc-7bb3ab0ef97d.png)  

## 힙의 삽입  

1. 힙에 새로운 요소가 들어오면 일단 새 노드를 힙의 마지막 노드에 이어서 삽입한다.  
2. 새로운 노드를 부모 노드들과 교환해서 힙의 성질을 만족시킨다.  

* 최대 힙에 8을 삽입하기  

![힙 값 삽입](https://user-images.githubusercontent.com/54384004/74102861-bad03a00-4b8a-11ea-8d95-2a5206205bcc.png)  

* Java를 이용한 최대 힙 삽입 연산  
```
/* 최대힙 삽입 */
void insert_max_heap(int x){
    maxHeap[++heapSize] = x; // 힙 크기를 하나 증가하고 마지막 노드에 x를 넣는다.

    for (int i=heapSize; i>1; i/=2) {
    // 마지막 노드가 자신의 부모 노드보다 크면 swap
    if (maxHeap[i/2] < maxHeap[i]) {
        swap(i/2, i);
    } else {
        break;
    }
    }
}
```

## 힙의 삭제  

1. 최대 힙에서의 최댓값은 루트 노드이므로 루트 노드가 삭제된다.  
    * 최대 힙에서의 삭제 연산은 최댓값을 가진 요소를 삭제하는 것이다.  
2. 삭제된 루트 노드에는 힙의 마지막 노드를 가져온다.  
3. 힙을 재구성한다.  

* 최대 힙의 최댓값 삭제하기  

![최대 힙 최댓값 삭제](https://user-images.githubusercontent.com/54384004/74102906-1d293a80-4b8b-11ea-8179-aabc0497e7ad.png)  

* Java를 이용한 최대 힙 삭제  
```
/* 최대힙 삭제 */
int delete_max_heap(){
    if (heapSize == 0) // 배열이 빈 경우
    return 0;

    int item = maxHeap[1]; // 루트 노드의 값을 저장한다.
    maxHeap[1] = maxHeap[heapSize]; // 마지막 노드의 값을 루트 노드에 둔다.
    maxHeap[heapSize--] = 0; // 힙 크기를 하나 줄이고 마지막 노드를 0으로 초기화한다.

    for (int i=1; i*2<=heapSize;) {
    // 마지막 노드가 왼쪽 노드와 오른쪽 노드보다 크면 반복문을 나간다.
    if (maxHeap[i] > maxHeap[i*2] && maxHeap[i] > maxHeap[i*2+1]) {
        break;
    } 
    // 왼쪽 노드가 더 큰 경우, 왼쪽 노드와 마지막 노드를 swap
    else if (maxHeap[i*2] > maxHeap[i*2+1]) {
        swap(i, i*2);
        i = i*2;
    }
    // 오른쪽 노드가 더 큰 경우, 오른쪽 노드와 마지막 노드를 swap
    else {
        swap(i, i*2+1);
        i = i*2+1;
    }
    }
    return item;
}
```

## Reference  
 
* [[자료구조]힙(heap)이란](https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html)  

# 동적계획법  

문제의 최적해를 구하거나 답의 개수를 세는 과정에 사용할 수 있는 설계 기법  
불필요한 계산을 줄이고 효율적으로 최적해를 찾을 수 있다.  

**전체 문제를 작은 문제로 단순화한 다음 점화식으로 만들어 재귀적인 구조를 활용해서 전체 문제를 해결하는 방식**  

1. 전체 문제를 작은 문제로 단순화 한다. -> 부분 문제를 정의한다.  
2. 재귀적인 구조를 활용할 수 있는 점화식을 만든다. -> 점화식을 만든다.  
3. 작은 문제를 해결한 방법으로 전체 문제를 해결한다. -> 문제를 해결한다.  

## 동적계획법 조건  

1. 겹치는 부분(작은) 문제로 쪼개질 수 있어야 한다.  
    * 예): 피보나치수열   
2. 최적 부분구조 : 어떤 문제의 최적의 해결책이 그 부분 문제의 최적의 해결책으로부터 설계될 수 있는 경우 
    * 문제의 정답을 작은 문제의 정답으로부터 구할 수 있다.  

## 메모이제이션  

동적계획법에서 각 문제는 한 번만 풀어야 한다.  
최적 부분구조를 만족하기 때문에, 같은 문제는 구할 때마다 정답이 같다.  
따라서 한번 구했으면 캐싱을 해놓아야 한다.  

```
int memo[100];
int fibonacci(int n) {
    if (n <= 1) {
    	return n;
    } else {
    	memo[n] = fibonacci(n-1) + fibonacci(n-2);
    	return memo[n];
    }
}
```

## 동적계획법 구현방식  

### 1) Top-down: 큰 문제를 작은 문제로 쪼개면서 푼다.

재귀를 이용하여 구현한다.  

#### 예시 :: 피보나치 수열  

1. 문제를 작은 문제로 나눈다. 
    * fibo(n-1)과 fibo(n-2)로 문제를 나눈다.  
2. 작은 문제를 푼다.  
    * fibo(n-1)과 fibo(n-2)을 호출해 문제를 푼다.  
3. 이제 큰 문제를 푼다.  
    * fibo(n-1) + fibo(n-2)  
    
```
int d[100];
int fibonacci(int n) {
    if (n <= 1) {
    	return n;
    } else {
        if (d[n] > 0) {		// d의 값이 0이 아니면
            return d[n];	// 그 값을 그대로 사용
        }
        d[n] = fibonacci(n-1) + fibonacci(n-2);     //캐싱  
        return d[n];
    }
}
```

## 2) Bottom-up: 작은 문제부터 차례대로 푼다.  
    
반복문을 이용해서 푼다.  

#### 예시 :: 피보나치 수열  

1. 문제를 크기가 작은 문제부터 차례대로 푼다.  
    * for(int i = 2; i <= n; i++)  
2. 문제의 클기를 조금씩 크게 만들면서 문제를 크게 풀어간다.   
    * for(int i = 2; i <= n; i++)  
3. 작은 문제를 풀면서 왔기에 큰 문제는 항상 풀수 있다.  
    * d[i] = d[i-1] + d[i-2]  
4. 반복하다 보면 가장 큰 문제를 풀 수 있다.  
    * d[n]을 구하게 된다.  
    
```
int d[100];
int fibonacci(int n) {
    d[0] = 0;
    d[1] = 1;
    for (int i=2; i<=n; i++) {	// 2에서 부터 시작해서 n까지 반복
    	d[i] = d[i-1] + d[i-2];
    }
    return d[n];
}
```  

## 예시 문제: 격자상의 경로  

![image](https://user-images.githubusercontent.com/54384004/98763303-16329f80-241d-11eb-8206-73fdf1e08415.png)

NxN 격자가 있을 때, 왼쪽 위부터 오른쪽 아래까지 갈 때의 가장 최적의 경로 (최댓값)을 찾는 문제.  
방향은 오직 오른쪽과 아래만으로 가능하다.  

### 해결 방법  

1. 부분 문제를 정의한다.  
    * 왼쪽 위를 (0, 0), 오른쪽 아래를 (4, 4)로 하는 좌표를 기준으로 sum이라는 새로운 2차배열을 만든다 (캐싱을 위해)  
    * sum에는 (y,x) 좌표까지의 최댓값을 캐싱한다.  
2. 점화식을 구한다.  
    * sum(y,x)는 sum(y, x-1)이나 sum(y-1,x) 중에 큰 값을 골라서 원래 격자에 주어진 sum(y,x)값을 더하면 구해진다.  
    * `sum(y,x) = max(sum(y, x-1), sum(y-1, x)) + value(y,x)`
3. 이중 for문으로 1부터 배열 길이만큼 sum 배열을 채워 넣으면 sum(n,n)의 값을 구할 수 있다.  

```
var value = [
    [3, 7, 9, 2, 7],
    [9, 8, 3, 5, 5],
    [1, 7, 9, 8, 5],
    [3, 8, 6, 4, 10],
    [6, 3, 9, 7, 8]    
];
var sum = [];
for (var i = 0; i < value.length; i++) {
    sum[i] = [];
}
sum[0][0] = value[0][0];
var colSum = sum[0][0];
var rowSum = sum[0][0];
for (var i = 1; i < value.length; i++) {
    colSum += value[i][0];
    sum[i][0] = colSum;
}
for (var i = 1; i < value.length; i++) {
    rowSum += value[0][i];
    sum[0][i] = rowSum;
}

for (var y = 1; y < value.length; y++) {
    for (var x = 1; x < value[0].length; x++) {
        if (sum[y][x - 1] > sum[y -1][x])  {
            sum[y][x] =  sum[y][x - 1]  + value[y][x];   
        } else {
            sum[y][x] = (sum[y -1][x] + value[y][x]);
        }
    }
}
console.log(sum[4][4]);
```
## Reference  
* [동적계획법 정리](https://medium.com/@wooder2050/%EB%8F%99%EC%A0%81%EA%B3%84%ED%9A%8D%EB%B2%95-dynamic-programming-%EC%A0%95%EB%A6%AC-58e1dbcb80a0)
* [동적계획법](https://velog.io/@polynomeer/%EB%8F%99%EC%A0%81-%EA%B3%84%ED%9A%8D%EB%B2%95Dynamic-Programming)  

# 탐욕법(Greedy Algorithm)  

동적 프로그래밍 사용시 지나치게 일을 많이 한다는 것에서 착안하여 고안된 알고리즘  
동적 프로그래밍을 보완하는 개념이다.  
문제를 해결하는 과정에서 그 순간순간마다 최적이라고 생각되는 결정을 하는 방식으로 진행하여 최종 해답에 도달하는 문제 해결 방식  
미래를 생각하지 않고 각 단계에서 최선의 선택을 하는 기법  
각 단계에서의 최선의 선택이 전체적으로도 최선이길 바라는 알고리즘  

## 예제 1 : 활동 선택 문제 (Activity Selection Problem)  

한 강의실에서 여러 개의 수업을 하려고 할 때, 한번에 가장 많은 수업을 할 수 있는 경우를 고르자.  
(Si: 시작 시간, Fi: 종료시간)  
한 강의실에서 수업하기 때문에 시간이 겹치면 선택할 수 없다.  
![image](https://user-images.githubusercontent.com/54384004/98771415-c3aab080-2427-11eb-9099-41b94c5a7d53.png)

### 해결 (동적 프로그래밍 이용)  

* G18 : A1이 종료된 후부터 A8이 시작하기 전 활동들의 집합  
    * G18 = {A3, A5, A6, A7}
* 이 중에서의 최적의 조합 (활동들이 겹치지 않고 개수는 최대)을 B18 이라고 하면,  
    * B18 = {A3, A6}, {A3, A7}
* B18에서 A6을 골랐을 때, 문제는 두 개로 쪼개진다.  
    * G16과 G68에서 각각 최적인 B16과 B68을 찾는 것이다.   
    * 점화식 : C[i,j] = max(C[i,k] + C[k,j] + 1) (C: Gij의 최적의 개수)
* 이렇게 하면 우리는 모든 C들을 구해야한다.  

### 해결 (그리디 알고리즘)    

1. 첫번째 활동은 가장 먼저 끝나는 것이로 선택하는 것이 현재의 상황에서 가장 최선의 선택이다.  
2. 가장 먼저 끝나는 A1 활동을 실시한다.  
3. A1 활동이 끝난 후 또 다시 빠르게 끝낼 수 있는 활동을 찾는다.  
4. 그 활동을 실시한다.  
5 ... 반복  

```
var activity = [[1,1,3], [2,2,5], [3,4,7], [4,1,8], [5,5,9], [6,8,10], [7,9,11], [8,11,14], [9,13,16]];
function activitySelection(act) {
  var result = [];
  var sorted = act.sort(function(prev, cur) {
    return prev[2] - cur[2]; // 끝나는 시간 순으로 정렬
  });
  var last = 0;
  sorted.forEach(function(item) {
    if (last < item[1]) { // 조건 만족 시 결과 집합에 추가
      last = item[2];
      result.push(item);
    }
  });
  return result.map(function(r) {
    return r[0]; // map을 한 이유는 그냥 몇 번째 행동이 선택되었는지 보여주기 위함.
  });
}
activitySelection(activity); // [1, 3, 6, 8]
```

## 예제 2 : 분할 가능 배낭 문제  

무게에 따라 물건을 넣는 배낭. 가치가 높은 것부터 넣는 것이 좋다. 무거울 경우 쪼개서 넣을 수 있다.  

![image](https://user-images.githubusercontent.com/54384004/98773095-8c3e0300-242b-11eb-8ed1-860236c7e138.png)

1. 무게 대비 가치가 높은 것들을 먼저 넣는다.  
2. 초과될 경우 쪼개서 넣는다.  

## 탐욕법의 조건  
1. 탐욕스러운 선택 조건  
2. 최적 부분 구조 조건  

## Reference  
* [동적계획법과 탐욕법](https://velog.io/@cyranocoding/%EB%8F%99%EC%A0%81-%EA%B3%84%ED%9A%8D%EB%B2%95Dynamic-Programming%EA%B3%BC-%ED%83%90%EC%9A%95%EB%B2%95Greedy-Algorithm-3yjyoohia5)  
* [그리디 알고리즘](https://www.zerocho.com/category/Algorithm/post/584ba5c9580277001862f188)  