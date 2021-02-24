package Demo;

import java.io.*;

/** @Author jiaopenghui @Date 2021/1/5 8:23 下午 */
public class ReadFile {
  public static void main(String[] args) {
    //    boolean res = mothed("an.txt", "abc");
    //    System.out.println(res);

    boolean ret = readFileStr("a.txt", "abc");
    System.out.println(ret);
  }

  public static boolean mothed(String file, String str) {
    if (file == null || file.length() == 0 || str == null || str.length() == 0) {
      return false;
    }
    try (FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader raf = new BufferedReader(isr); ) {

      String s = null;
      while ((s = raf.readLine()) != null) {
        if (s.contains(str)) {
          return true;
        }
      }
    } catch (IOException e) {
      System.out.println("异常");
    }

    return false;
  }

  public static boolean readFileStr(String file, String str) {
    byte[] bytes = new byte[] {'g', 'h', 'i'};
    char[] arr = new char[5];
    int len;
    String s;
    try (FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        BufferedWriter bw = new BufferedWriter(osw)) {
      fos.write(bytes);
      fos.write(bytes);
      osw.write("jkl");
      osw.append("mno");
      bw.write("pqr");
      bw.newLine();
      bw.write("stu");

    } catch (Exception e) {
      System.out.println("异常");
    }
    return false;
  }
}
