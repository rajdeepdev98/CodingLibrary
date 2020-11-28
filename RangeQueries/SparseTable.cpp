#include<bits/stdc++.h>

using namespace std;

const int L=30;
const int N=int(1e5)+5;

int arr[N];//the array on which queries are to be performed
int ST[N][L];//the sparse table
int n;//size of the array

void precomputemin(){
    
    for(int i=1;i<=n;i++){//1 indexed array

            ST[i][0]=arr[i];//ST[i][j] will have ans for range[i,i+2^j-1]

    }

    for(int j=1;j<L;j++){

        for(int i=1;i+(1<<j)<=n+1;i++){

            ST[i][j]=min(ST[i][j-1],ST[i+(1<<(j-1))][j-1]);
        }
    }
    



}
// I thought of using sparse table for range sum but in case of arrays,its not that important
// Its more important in graphs for binary lifting
int query(int l,int r){

    int ans=INT_MAX;
    int dis=r-l+1;
    //now the tricky part used in case of idempotent functions
    int lr=log2(dis);
    int ld=1<<lr;
    ans=min(ST[l][lr],ST[r-ld+1][lr]);
    return ans;





}
void precomputemax(){


}

void precomputesum(){


}



int main(){





}