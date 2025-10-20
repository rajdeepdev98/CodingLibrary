template<typename T>
struct Tree {
	

    vector<T>vec;
    vector<T>lazy;
    int nt,n;
    Tree(int ntemp){
        nt=ntemp;
        vec.resize(nt);
    }
    Tree(T arr[],int n){
        this->n=n;
        nt=4*n+205;
        vec.resize(nt);
        lazy.resize(nt,0ll);
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
    void update2(T arr[],int node,int start,int end,int l,int r,T val){

         if(start>r || end<l)return;
        if(lazy[node]!=0){

            vec[node]+=(end-start+1)*lazy[node];
            lazy[2*node]+=lazy[node];
            lazy[2*node+1]+=lazy[node];
            lazy[node]=0;

        }
       
        if(start>=l && end<=r){
            vec[node]+=(end-start+1)*val;
            if(start!=end){
                lazy[2*node]+=val;
                lazy[2*node+1]+=val;
            }
            return;
        }
        //cout<<"hello"<<endl;
        int mid=(start+end)/2;
        update2(arr,2*node,start,mid,l,r,val);
        update2(arr,2*node+1,mid+1,end,l,r,val);
        vec[node]=comb(vec[2*node],vec[2*node+1]);
        //cout<<"hello2"<<endl;


    }
    void update(T arr[],int l,int r,T val){

            update2(arr,1,1,n,l,r,val);

    }
    T query(int l,int r){
        return query2(1,1,n,l,r);
    }

    T query2(int node,int start,int end,int l,int r){

            if(start>r || end<l)return 0;//for sum
            if(lazy[node]!=0){

                vec[node]+=(end-start+1)*lazy[node];
                lazy[2*node]+=lazy[node];
                lazy[2*node+1]+=lazy[node];
                lazy[node]=0;
            }
            if(start>=l && end<=r){

                return vec[node];
            }
            int mid=(start+end)/2;
            T a1=query2(2*node,start,mid,l,r);
            T b1=query2(2*node+1,mid+1,end,l,r);
            return comb(a1,b1);

    }
    
    T comb(T &a,T &b){

        return a+b;//or min or sum which means any associative function
    }


};

