package RangeQueries;

public class BIT {

    private int [] arr;
    private int n;

    public BIT(int n){

        this.n = n;
        this.arr = new int[n+1];
    }
    //Build from array
    public BIT(int []arr){

        this.n = arr.length;
        this.arr = new int[this.n+1];

        for(int i = 1;i<=n;i++){

            this.update(i, arr[i-1]);
        }

    }

    public void update(int idx, int delta){

        while(idx<=n){

            this.arr[idx]+=delta;
            idx+=(idx&(-idx));
        }
    }

    public int query(int idx){

        int sum = 0;
        while(idx>0){

            sum+= this.arr[idx];
            idx-=(idx&(-idx));
        }
        return sum;
    }
}
