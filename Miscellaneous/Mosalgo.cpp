#include<bits/stdc++.h>
#define pb push_back
#define ff first
#define ss second
#define mp make_pair
//THis algorithm solves the number of distinct elements within range queries

using namespace std;

const int N=(int)(3e4)+5;
const int Qm=(int)(2e5)+5;


int arr[N],rev[N],cnt[N],currans,ans[Qm];


struct Query{

    int idx,l,r,lb,rb;
}q[Qm];

bool cmp(Query a,Query b){

    return a.lb <b.lb ||(a.lb==b.lb && a.r<b.r);
}

void add_element(int x){
    if(++cnt[arr[x]]==1){

        currans++;
    }



}
void remove_element(int x){

    if(--cnt[arr[x]]==0)currans--;
}

void Mosalgo(){

    int n;
    cin>>n;
    for(int i=1;i<=n;i++)cin>>arr[i];
    map<int,int>mt;
    int block=max(1,(int)(pow(n,0.5)));


    int x,y;
    int m;
    cin>>m;
    for(int i=1;i<=m;i++){

        cin>>x>>y;
        q[i]={i,x,y,x/block,y/block};
    }
    //coordinate compression
    for(int i=1;i<=n;i++)mt[arr[i]];
    int cval=1;
    for(auto &el:mt){

        el.ss=cval++;
        rev[el.ss]=el.ff;


    }
    for(int i=1;i<=n;i++)arr[i]=mt[arr[i]];
    //compression done(This looked elegant than I way I do it(thats great too but different,more first principlic))
    sort(q+1,q+m+1,cmp);
    for(int i=1,L=1,R=0;i<=m;i++){


        while(R<q[i].r)add_element(++R);
        while(L>q[i].l)add_element(--L);
        while(R>q[i].r)remove_element(R--);
        while(L<q[i].l)remove_element(L++);
       ans[q[i].idx]=currans;
    }

    for(int i=1;i<=m;i++)cout<<ans[i]<<"\n";







}



int main(){

    
    Mosalgo();





    return 0;
}