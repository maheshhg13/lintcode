package LinkedIn.Interview;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            int len = 0;
            List<String> mid = new ArrayList<>();
            while (i < words.length && (len+mid.size()+words[i].length()) <= maxWidth) {
                mid.add(words[i]); len += words[i].length(); ++i;
            }
            if (i == words.length || mid.size() <= 1) {
                // last line or one String line
                StringBuilder line = new StringBuilder();
                for (int k = 0; k < mid.size()-1; k++) {
                    line.append(mid.get(k)); line.append(' ');
                }
                line.append(mid.get(mid.size()-1));
                int space = maxWidth-line.length();
                for (int k = 0; k < space; k++) line.append(' ');
                res.add(line.toString());
                if (i == words.length) break;
            } else {
                // lines
                StringBuilder line = new StringBuilder();
                int space = (maxWidth-len)/(mid.size()-1);
                int evenl = (maxWidth-len)%(mid.size()-1);
                for (int k = 0; k < mid.size()-1; k++) {
                    line.append(mid.get(k));
                    for (int h = 0; h < space; h++) line.append(' ');
                    if (evenl > 0) { line.append(' '); --evenl; }
                }
                line.append(mid.get(mid.size()-1));
                res.add(line.toString());
            }
            --i;
        }
        
        return res;
    }
}
