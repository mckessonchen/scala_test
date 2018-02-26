import org.jsoup.Jsoup

/**
  * Created by chenteng on 2018/1/8.
  */


object TestOne {
  def main(args: Array[String]): Unit = {
    val ip = "182.50.124.75"
    val html = Jsoup.connect("http://www.cip.cc/"+ip).execute().body()
//    val html = " <div class=\"data kq-well\">\n          <pre>IP : 119.7.72.59 地址 : 中国 四川 德阳 数据二 : 四川省德阳市 | 联通 URL : http://www.cip.cc/119.7.72.59</pre></div>\n        <div class=\"kq-well\">\n          <div class=\"cmd-title\">\n            <strong>命令行查询(详细):</strong></div>\n          <div class=\"sys-cmd\">\n            <ul>\n              <li>UNIX/Linux:\n                <span>\n                  <code>#curl cip.cc</code></span>\n              </li>\n              <li>Windows:\n                <span>\n                  <code>>telnet cip.cc</code></span>\n              </li>\n              <li>&nbsp;\n                <span>\n                  <code>>ftp cip.cc</code></span>\n              </li>\n            </ul>\n          </div>"
//    val html = " <div class=\"data kq-well\">\n          <pre>IP : 182.50.124.73 地址 : 中国 北京市 运营商 : 皓宽网络 数据二 : 北京市 | 北京光电新创通信技术有限公司 URL : http://www.cip.cc/182.50.124.73</pre></div>"
    val pre = Jsoup.parse(html).select("div[class=data kq-well]").select("pre")
    if (!pre.isEmpty) {
      val matcher = "数据二\t: (.*省)?(.*)市 \\|".r.pattern.matcher(pre.text())
      var province = ""
      var city = ""
      if (matcher.find()){
        province = matcher.group(1)
        city = matcher.group(2)
        System.out.println("count :"+matcher.groupCount())
        System.out.println("0 :"+matcher.group())
        System.out.println("1 :"+matcher.group(1).replace("省",""))
        System.out.println("2 :"+matcher.group(2))
      }
      System.out.println("over")

    }
  }
}
