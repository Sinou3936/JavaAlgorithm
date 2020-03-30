package chap07;

public class IntSortedSet {
    private int max;
    private int[] set;
    private int num;

    public IntSortedSet(int capacity){
        num = 0;
        max = capacity;
        try {
            set = new int[capacity];
        }catch (OutOfMemoryError e){
            max = 0;
        }
    }
    public int capacity(){
        return max;
    }
    public int size(){
        return num;
    }
    public int indexOf(int n){
        int pl = 0;
        int pr = n-1;

        do {
            int pc = (pl + pr) /2;
            if(set[pc] == n) return  pc;
            else if(set[pc] < n)
                pl = pc+1;
            else
                pl = pc -1;
        }while (pl <= pr);

        return  -pl -1;
    }
    public boolean contains(int n){
        return (indexOf(n) != -1) ? true: false;
    }
    public boolean add(int n){
        int idx;
        if(num >= max || (idx = indexOf(n)) >= 0)
            return  false;
        else {
            idx = -(idx +1);
            num++;
            for(int i=num -1; i>idx; i--) {
                set[i] = set[i-1];
            }
            set[idx] = n;
            return true;
        }
    }
    public boolean remove(int n){
        int idx;
        if(num <=0 || (idx = indexOf(n)) == -1) return  false;
        else{
           num--;
           for(int i=idx; i<num; i++)
               set[i] = set[i+1];
            return  true;
        }

    }
    public void ToCopy(IntSortedSet s){
        int n = (s.max < num) ? s.max : num;
        for(int i=0; i<n; i++){
            s.set[i] = set[i];
        }
        s.num = n;
    }
    public void copyFrom(IntSortedSet s){
        int n = (max < s.num) ? max : s.num;
        for(int i=0; i<n; i++)
            set[i] = s.set[i];
        num = n;
    }
    public boolean equalTo(IntSortedSet s){
        if(num != s.num) return  false;

        for (int i=0; i<num; i++){
            int j=0;
            for(; j<s.num; j++)
                if(set[i] == s.set[j]) break;
            if(j == s.num) return  false;
        }
        return true;
    }
    public void unionOF(IntSortedSet s1, IntSortedSet s2){
        copyFrom(s1);
        for(int i=0; i<s2.num; i++)
            add(s2.set[i]);
    }
    public String toString(){
        StringBuffer temp = new StringBuffer("{");
        for(int i=0; i<num; i++) temp.append(set[i]+" ");
        temp.append("}");
        return temp.toString();
    }

    public boolean isEmpty(){
        return  num<=0;
    }
    public boolean isFull(){
        return  num>max;
    }
    public void clear(){
        num = 0;
    }
    public boolean add(IntSortedSet s){
        boolean flag = false;
        for(int i=0; i<num; i++){
            if(add(set[i]) == true)
                flag = true;
        }
        return flag;
    }
    public boolean retain(IntSortedSet s){
        boolean flag = false;
        for(int i=0; i<num; i++){
            if(s.contains(set[i]) == true)
                remove(set[i]);
            flag = true;
        }
        return flag;
    }
    public boolean remove(IntSortedSet s){
        boolean flag = false;
        for(int i=0; i<num; i++){
            if(s.contains(set[i]) == true)
                remove(set[i]);
            flag = true;
        }
        return flag;
    }

    public boolean isSubSetOf(IntSortedSet s){
        for(int i=0; i<num; i++){
            int j=0;
            for(; j<s.num; j++)
                if(set[i] == s.set[i]) break;
            if(j == s.num) return  false;
        }
        return true;
    }

    public boolean isProperSubsetOf(IntSortedSet s){
        if(num >= s.num) return false;
        return  s.isSubSetOf(s);
    }

    public void intersectionOf(IntSortedSet s1, IntSortedSet s2){
        clear();
        for(int i=0; i<num; i++)
            if(s2.contains(s1.set[i])) add(s1.set[i]);
    }
    public void differenceOf(IntSortedSet s1, IntSortedSet s2){
        clear();
        for(int i=0; i<num; i++)
            if(!s2.contains(s1.set[i])) add(s1.set[i]);
    }


}
