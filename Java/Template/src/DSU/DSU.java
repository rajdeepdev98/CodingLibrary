package DSU;

class DSU{

    int [] parent;
    int [] rank;

    public DSU(int n){
        parent = new int[n+1];
        rank = new int[n+1];
        for (int i=0;i<=n;i++){
            parent[i] = i; // each node is its own parent initially
            rank[i] = 0;
        }
    }

    //Find with path compression
    public int find(int x){

        if(parent[x] != x){
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public boolean isSameSet(int x, int y){
        return find(x) == find(y);
    }
    public boolean union(int x, int y){

        int rootX = find(x);
        int rootY = find(y);

        if(rootX == rootY){
            return false; // already in same set
        }
        else{
            // Union by rank
            if(rank[rootX] < rank[rootY]){
                parent[rootX] = rootY;
            }
            else if(rank[rootX] > rank[rootY]){
                parent[rootY] = rootX;
            }
            else{
                parent[rootY] = rootX;
                rank[rootX]++;
            }
            return true;
            // union by size commented out

            /*
            if(size[rootX] < size[rootY]){
                parent[rootX] = rootY;
                size[rootY] += size[rootX];

            }
            else{
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
                }

            return true;
             */

        }



    }


    public static void main(String[] args) {




    }

}