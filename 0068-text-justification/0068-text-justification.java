class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            int j = i, len = 0;
            List<String> list = new ArrayList<>();
            while(j < words.length && len + words[j].length() + list.size() <= maxWidth) {
                len += words[j].length();
                list.add(words[j]);
                j++;
            }
            
            StringBuilder str = new StringBuilder();
            
            if(j >= words.length) { //last line
                for(int x = 0; x < list.size(); x++) {
                    str.append(list.get(x));
                    if(x != list.size() - 1) {
                        str.append(" ");
                    }
                }
                str.append(space(maxWidth - str.length()));
            } else {
                if(list.size() == 1) {
                    str.append(list.get(0));
                    str.append(space(maxWidth - str.length()));
                    res.add(str.toString());
                    i = j - 1;
                    continue;
                }
                
                int gap = list.size() - 1;
                int remain = maxWidth - len;
                int k = remain / gap, m = remain % gap;
                
                for(int x = 0; x < list.size(); x++) {
                    str.append(list.get(x));
                    if(x != list.size() - 1) {
                        str.append(space(k));
                        if(m > 0) {
                            m--;
                            str.append(" ");
                        }
                    }
                }
            }
            res.add(str.toString());
            i = j - 1;
        }
        return res;
    }
    
    public String space(int n) {
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < n; i++) {
            str.append(" ");
        }
        return str.toString();
    }
}