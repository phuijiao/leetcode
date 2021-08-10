package shopee;

public class GetXMLValue {
  public static void main(String[] args) {
    String res = GetXMLValue("<people><name>shopee</name></people>", "people.name");
    System.out.println(res);
  }
  public static String GetXMLValue(String inxml, String path) {
    // write code here
    int index = inxml.indexOf("/");
    String s = inxml.substring(0, index+1);
    String s1 = s.replaceAll("<", "");
    String[] split1 = s1.split(">");
    String[] split2 = path.split("\\.");
    int len1 = split1.length;
    int len2 = split2.length;
    if (len1 - 1 != len2) {
      return "";
    }
    for (int i = 0; i < len2; i++) {
      if (!split1[i].equals(split2[i])) {
        return "";
      }
    }
    return split1[len2];

  }

  public static String GetXMLValue1(String inxml, String path) {
    // write code here

      String s1 = inxml.replaceAll("<", "");
      String[] split1 = s1.split(">");
      String[] split2 = path.split("\\.");
      int len2 = split2.length;

      for (int i = 0; i < len2; i++) {
        if (!split1[i].equals(split2[i])) {
          return "";
        }
      }
      String[] split = split1[len2].split("/");
      return split[0];
  }
}
