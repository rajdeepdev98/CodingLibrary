/*

   *  Disjoint Set Data Structure
   *  Complexity : O(alpha(n))(Inverse Ackermann Function)
   *  Source: Tourist 
   *  Modified by : Rajdeep Deb
   *  Date : 16-01-2021


*/

struct DSU
{
    /* data */

    vector<int>p;
    vector<int>s;
    int n;
    DSU(int nd):n(nd){

        p.resize(n);
        s.resize(n);
        iota(p.begin(),p.end(),0);
        fill(s.begin(),s.end(),1);
    }
    int find(int x){

        return x==p[x]?x:(p[x]=find(p[x]));

    }
    bool same_set(int a,int b){
        return find(a)==find(b);
    }
    void join(int a,int b){

        int x=find(a),y=find(b);
        if(x!=y){

           // p[x]=y; 
           if(s[x]>s[y])swap(x,y);
           
           p[x]=y;


           s[y]+=s[x];//considering the set y to be bigger in size
        }

    }

    
};
