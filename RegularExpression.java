import java.util.regex.Matcher;  
import java.util.regex.Pattern;

public class RegularExpression {
    private String mPatternType = "default";

    private final String PATTERN_TYPE_MAIL = "mail";
    private final String PATTERN_TYPE_MMICODE = "mmicode";
    private final String PATTERN_TYPE_CURRENCY = "currency";

    Pattern mmiPattern = Pattern.compile(
        "((\\*|#|\\*#|\\*\\*|##)(\\d{2,3})(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*)(\\*([^*#]*))?)?)?)?#)(.*)");
   /*     1 2                     3         4   5       6   7       8   9       10  11                12   */

    Pattern mailPattern = Pattern.compile(
        "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$");

    Pattern currencyPattern = Pattern.compile(
        "^[0-9]{1,3}(,[0-9]{3})*(.[0-9]{1,2})?$");

    Pattern defaultPattern = Pattern.compile(
        "^[a-zA-Z0-9]+$");

    String mGroup1;
    String mGroup2;
    String mGroup3;
    String mGroup4;
    String mGroup5;
    String mGroup6;
    String mGroup7;
    String mGroup8;
    String mGroup9;
    String mGroup10;
    String mGroup11;
    String mGroup12;

  
    final int MATCH_GROUP_1 = 1;
    final int MATCH_GROUP_2 = 2;
    final int MATCH_GROUP_3 = 3;
    final int MATCH_GROUP_4 = 4;
    final int MATCH_GROUP_5 = 5;
    final int MATCH_GROUP_6 = 6;
    final int MATCH_GROUP_7 = 7;
    final int MATCH_GROUP_8 = 8;
    final int MATCH_GROUP_9 = 9;
    final int MATCH_GROUP_10 = 10;
    final int MATCH_GROUP_11 = 11;
    final int MATCH_GROUP_12 = 12;

    String makeEmptyNull (String s) {
        if (s != null && s.length() <= 0) {
            return null;
        }
        return s;
    }
  
    public RegularExpression(String patternType) {
        mPatternType = patternType;
    }
  
    void matchPatternString(String str) {
        Matcher matcher;

        if(mPatternType.equals(PATTERN_TYPE_MMICODE)) {
            matcher = mmiPattern.matcher(str);
        } else if(mPatternType.equals(PATTERN_TYPE_MAIL)) {
            matcher = mailPattern.matcher(str);	
        } else if(mPatternType.equals(PATTERN_TYPE_CURRENCY)) {
            matcher = currencyPattern.matcher(str);	
        }else {
            matcher = defaultPattern.matcher(str);
        }

        if (matcher.matches()) {
            if(matcher.groupCount() >= 1) {
                mGroup1 = makeEmptyNull(matcher.group(MATCH_GROUP_1)); // 1
            }
            if(matcher.groupCount() >= 2) {
                mGroup2 = makeEmptyNull(matcher.group(MATCH_GROUP_2)); // 2
            }
            if(matcher.groupCount() >= 3) {
                mGroup3 = makeEmptyNull(matcher.group(MATCH_GROUP_3)); // 3
            }
            if(matcher.groupCount() >= 4) {
                mGroup4 = makeEmptyNull(matcher.group(MATCH_GROUP_4)); // 4
            }
            if(matcher.groupCount() >= 5) {
                mGroup5 = makeEmptyNull(matcher.group(MATCH_GROUP_5)); // 5
            }
            if(matcher.groupCount() >= 6) {
                mGroup6 = makeEmptyNull(matcher.group(MATCH_GROUP_6)); // 6
            }
            if(matcher.groupCount() >= 7) {
                mGroup7 = makeEmptyNull(matcher.group(MATCH_GROUP_7)); // 7
            }
            if(matcher.groupCount() >= 8) {
                mGroup8 = makeEmptyNull(matcher.group(MATCH_GROUP_8)); // 8
            }
            if(matcher.groupCount() >= 9) {
                mGroup9 = makeEmptyNull(matcher.group(MATCH_GROUP_9)); // 9
            }
            if(matcher.groupCount() >= 10) {
                mGroup10 = makeEmptyNull(matcher.group(MATCH_GROUP_10)); // 10
            }
            if(matcher.groupCount() >= 11) {
                mGroup11 = makeEmptyNull(matcher.group(MATCH_GROUP_11)); // 11
            }
            if(matcher.groupCount() >= 12) {
                mGroup12 = makeEmptyNull(matcher.group(MATCH_GROUP_12)); // 12
            }

            System.out.println("\tmGroup1:	" + mGroup1 + "\n"
                + "\tmGroup2:	" + mGroup2 + "\n"
                + "\tmGroup3:	" + mGroup3 + "\n"
                + "\tmGroup4:	" + mGroup4 + "\n"
                + "\tmGroup5:	" + mGroup5 + "\n" 
                + "\tmGroup6:	" + mGroup6 + "\n"
                + "\tmGroup7:	" + mGroup7 + "\n"
                + "\tmGroup8:	" + mGroup8 + "\n"
                + "\tmGroup9:	" + mGroup9 + "\n"
                + "\tmGroup10:	" + mGroup10 + "\n"
                + "\tmGroup11:	" + mGroup11 + "\n"
                + "\tmGroup12:	" + mGroup12 + "\n"
                + "---------------------------------------------\n");
        } else {
            System.out.println("" + mPatternType + " can't match " + str + "!!!\n"
                + "---------------------------------------------\n");
        }
    }
    
    public static void main(String[] args){
        if(args != null && args.length >= 2) {
            RegularExpression regular = new RegularExpression(args[0]);
            for(int i=1; i<args.length; i++) {
                if(args[i] != null) {
                    regular.matchPatternString(args[i]);
                }
            }
        } else {
            System.out.println("parameters is invalid!!");
            System.out.println("how to run program, as following:");
            System.out.println("java RegularExpression type string");
            System.out.println("type should be \"mmicode\", \"mail\", \"currency\"");
        }
    }
}
