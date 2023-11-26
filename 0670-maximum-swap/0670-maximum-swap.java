class Solution {
    public int maximumSwap(int num) {
        String s = num + "";
        char a[] = s.toCharArray();
        int l[] = new int[a.length];
        
        for(int i = 0; i < l.length; i++) {
            l[i] = a[i];
            if(i > 0) l[i] = Math.min(l[i - 1], l[i]);
        }
        
        int index = -1, max = -1;
        for(int i = l.length - 1; i >= 1; i--) {
            if(a[i] > l[i - 1]) {
                if(a[i] > max) {
                    max = a[i];
                    index = i;
                }
            }
        }
        
        if(index != -1) {
            for(int i = 0; i < index; i++) {
                if(a[i] < a[index]) {
                    char t = a[i];
                    a[i] = a[index];
                    a[index] = t;
                    break;
                }
            }
        }
        
        return Integer.parseInt(new String(a));
    }
}