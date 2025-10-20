 
template<typename T>
struct Tree {
	
 
    vector<T>vec;
    int nt,n;
    Tree(int ntemp){
        nt=ntemp;
        vec.resize(nt,0);
    }
    Tree(T arr[],int n){
        this->n=n;
        nt=5*n+1;
        vec.resize(nt,0);
        build(arr,1,1,n);
    }
    void init(T arr[],int n){
        this->n=n;
        build(arr,1,1,n);
 
    }
    void build(T arr[],int node,int start,int end){
 
            if(start==end){
                vec[node]=arr[start];
            }
            else{
 
                int mid=(start+end)/2;
                build(arr,2*node,start,mid);
                build(arr,2*node+1,mid+1,end);
                vec[node]=comb(vec[2*node],vec[2*node+1]);
            }
 
 
    }
    void update(T arr[],int idx,T val){
        update2(arr,1,1,n,idx,val);
    }
    void update2(T arr[],int node,int start,int end,int idx,T val){
 
            if(start==end){
                arr[start]=val;
                vec[node]=val;
            }
            else{
 
                int mid=(start+end)/2;
                if(idx>=start && idx<=mid){
                    update2(arr,2*node,start,mid,idx,val);
                }
                else{
                    update2(arr,2*node+1,mid+1,end,idx,val);
                }
                vec[node]=comb(vec[2*node],vec[2*node+1]);
            }
 
    }
    T query(int l,int r){
        return query2(1,1,n,l,r);
    }
    T query2(int node,int start,int end,int l,int r){
 
            if(start>r || end<l)return -1;//for sum its zero for min its max and for max its min
            if(start>=l && end<=r)return vec[node];
            int mid=(start+end)/2;
            T a1=query2(2*node,start,mid,l,r),b1=query2(2*node+1,mid+1,end,l,r);
            return comb(a1,b1);
 
    }
    T comb(T &a,T &b){
 
        return max(a,b);//or min or sum which means any associative function
    }
 
 
};