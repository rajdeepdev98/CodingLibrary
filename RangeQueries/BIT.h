void update(int ind,int val,int n){

    while(ind<=n){

            BIT[ind]+=val;
            ind+=(ind&(-ind));
    }



}
int query(int ind){

    int ans=0;
    while(ind>=1){

        ans+=BIT[ind];
        ind-=(ind&(-ind));
    }
    return ans;
}
