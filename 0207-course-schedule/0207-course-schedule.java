class Solution {
    public boolean canFinish(int n, int[][] edges) {
        List<Integer>[] adjecentList = new ArrayList[n];
    int[] indggree = new int[n];
    for(int i = 0; i < n; i++) {
      adjecentList[i] = new ArrayList<>();
    }

    for(int[] edge : edges) {
      int v = edge[0], u = edge[1];  //v <- u
      adjecentList[u].add(v);
      indggree[v]++;
    }

    Queue<Integer> q = new LinkedList<>();
    int takenCourse = 0;
    for(int i = 0; i < n; i++) {
      if(indggree[i] == 0) { //no pre
        q.add(i);
      }
    }

    while(q.size() > 0) {
      int u = q.poll();
      takenCourse++;
      for(int nextNode : adjecentList[u]) {
        indggree[nextNode]--;
        if(indggree[nextNode] == 0) { //all pre finish
          q.add(nextNode);
        }
      }
    }

    return takenCourse == n;
    }
}