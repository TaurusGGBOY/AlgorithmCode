class Solution {
  public String entityParser(String text) {
    text=text.replaceAll("&quot;","\"");
    text=text.replaceAll("&apos;","\'");
    text=text.replaceAll("&amp;","&");
    text=text.replaceAll("&gt;",">");
    text=text.replaceAll("&lt;","<");
    text=text.replaceAll("&frasl;","/");
    return text;
  }
}