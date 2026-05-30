package RangeQueries;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class SegmentTreeGeneric<T> {

    private T[] tree;
    private int n;
    private BinaryOperator<T> merge;
    private T identity;

    public SegmentTreeGeneric(int n, BinaryOperator<T> merge, T identity){

        this.n = n;
        this.tree = (T[]) new Object[4*n+1];
        this.merge = merge;
        this.identity = identity;
        Arrays.fill(tree, identity);

    }

    public SegmentTreeGeneric(T[] arr, BinaryOperator<T> merge, T identity){

        this.n = arr.length;
        this.tree = (T[]) new Object[4*n+1];
        this.merge = merge;
        this.identity = identity;
        build(0, 0, n-1, arr);

    }

    private void build(int node, int start, int end, T[] arr){

        if(start == end){

            tree[node] = arr[start];
            return;
        }

        int mid = start + (end-start)/2;

        build(2*node+1, start, mid, arr);
        build(2*node+2, mid+1, end, arr);

        tree[node] = merge.apply(tree[2*node+1], tree[2*node+2]);
    }

    public void update(int idx, T value){

        update(0, 0, n-1, idx, value);
    }

    private void update(int node, int start, int end, int idx, T value){

        if(start == end){
            tree[node] = value;
            return;
        }
        int mid = start + (end-start)/2;

        if(idx <= mid){

            update(2*node+1, start, mid, idx, value);
        }
        else {

            update(2*node+2, mid+1, end, idx, value);
        }

        tree[node] = merge.apply(tree[2*node+1], tree[2*node+2]);

    }

    public T query(int left, int right){

        return query(0, 0, n-1, left, right);
    }

    private T query(int node, int start, int end, int left, int right){

        if(end < left || start > right){

            return identity;
        }

        if(start >= left && end <= right){

            return tree[node];
        }

        int mid = start + (end-start)/2;

        T leftResult = query(2*node+1, start, mid, left, right);
        T rightResult = query(2*node+2, mid+1, end, left, right);

        return merge.apply(leftResult, rightResult);

    }

}
