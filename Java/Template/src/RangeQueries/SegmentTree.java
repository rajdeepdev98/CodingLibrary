package RangeQueries;

import java.util.Arrays;

public class SegmentTree {

    private int[] tree;
    private int n;

    public SegmentTree(int n){

        this.n = n;
        this.tree = new int[4*n+1];
        Arrays.fill(tree, Integer.MIN_VALUE);

    }

    public SegmentTree(int []arr){

        this.n = arr.length;
        this.tree = new int[4*n+1];
        build(0,0, n-1, arr);

    }

    private void build(int node, int start, int end, int []arr){

        if(start == end){

            tree[node] = arr[start];
            return;
        }

        int mid = start + (end-start)/2;

        build(2*node+1, start, mid, arr);
        build(2*node+2, mid+1, end, arr);

        tree[node] = Math.max(tree[2*node+1], tree[2*node+2]);
    }

    public void update(int idx, int value){

        update(0, 0, n-1, idx, value);
    }

    private void update(int node, int start, int end, int idx, int value){

        if(start == end){
            tree[node]=value;
            return;
        }
        int mid = start + (end-start)/2;

        if(idx<=mid){

            update(2*node+1, start, mid, idx, value);
        }
        else {

            update(2*node+2, mid+1, end, idx, value);
        }

        tree[node] = Math.max(tree[2*node+1], tree[2*node+2]);

    }

    public int query(int left, int right){

        return query(0, 0, n-1, left, right);
    }
    private int query(int node, int start, int end, int left, int right){

        if(end<left || start> right){

            return Integer.MIN_VALUE;
        }

        if(start>= left && end<=right){

            return tree[node];
        }

        int mid = start + (end-start)/2;

        int leftMax = query(2*node+1, start, mid, left, right);
        int rightMax = query(2*node+2, mid+1, end, left, right);

        return Math.max(leftMax, rightMax);



    }

}
