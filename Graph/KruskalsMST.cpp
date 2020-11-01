#include<bits/stdc++.h>
#define pb push_back

using namespace std;

struct edge{

    int a,b,w;
};

int par[100005];
vector<edge>edges;
int main(){

    int n,m;
    cin>>n>>m;
    int a,b,w;
    edge ed;
    for(int i=1;i<=m;i++){
        cin>>a>>b>>w;
        ed.a=a;
        ed.b=b;
        ed.w=w;
        edges.pb(ed);

    }
    //now lets build the mst    
    sort(edges.begin(),edges.end(),[](const edge& a,const edge& b)->bool{
        return a.w< b.w;
    });
    for(int i=1;i<=n;i++){
        par[i]=i;
    }
    //time to write the disjoint union function

    auto root =[](int i){
        while(par[i]!=i){
            par[i]=par[par[i]];
            i=par[i];
        }
        return i;


    };
    auto find =[&](int i,int j)->bool{

        return (root(i)==root(j));
    };


    auto disunion =[&](int i,int j){

        int roota=root(i);
        int rootb=root(j);
        par[roota]=rootb;

    };

    //lets build the mst now
    int cnt=0;
    int sm=0;
    vector<edge>mst;
    for(auto el:edges){
        if(root(el.a)!=root(el.b)){
            sm+=el.w;
            mst.pb(el);
            disunion(el.a,el.b);
            cnt++;
        }
        if(cnt==n-1)break;



    }
    cout<<sm<<"\n";
    return 0;








}

