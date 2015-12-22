package meiavy;

import java.io.IOException;
import java.util.Collection;

import org.easymock.EasyMock;

import junit.framework.TestCase;

public class SearcherTest extends TestCase {
	
	private String html="" + 
			"<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" + 
			"<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" + 
			"<head>\r\n" + 
			"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=gbk\" />\r\n" + 
			"<title>亚洲有码区 - bt下载 爱城 bt下载 </title>\r\n" + 
			"<meta name=\"keywords\" content=\"亚洲有码区,\" />\r\n" + 
			"<meta name=\"description\" content=\"爱城 bt下载 美女 女优\" />\r\n" + 
			"<link rel='archives' title='bt下载' href='bt/simple' />\r\n" + 
			"<link rel=\"alternate\" type=\"application/rss+xml\" title=\"RSS\" href=\"http://www.aisex.com/bt/rss.php?fid=4\" />\r\n" + 
			"<LINK href=\"http://www.uslink.info/thread.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
			"<script language=\"JavaScript\">\r\n" + 
			"var agt = navigator.userAgent.toLowerCase();\r\n" + 
			"var is_ie = ((agt.indexOf(\"msie\") != -1) && (agt.indexOf(\"opera\") == -1));\r\n" + 
			"var is_gecko= (navigator.product == \"Gecko\");\r\n" + 
			"var imgpath = 'image';\r\n" + 
			"if (location.href.indexOf('/simple/')!=-1) {\r\n" + 
			"	getObj('headbase').href = location.href.substr(0,location.href.indexOf('/simple/')+1);\r\n" + 
			"} else if (location.href.indexOf('.html')!=-1) {\r\n" + 
			"	var base = location.href.replace(/^(http(s)?:\\/\\/(.*?)\\/)[^\\/]*\\/[0-9]+\\/[0-9]{4,6}\\/[0-9]+\\.html$/i,'$1');\r\n" + 
			"	if (base!=location.href) {\r\n" + 
			"		getObj('headbase').href = base;\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"function getObj(id){\r\n" + 
			"	return document.getElementById(id);\r\n" + 
			"}\r\n" + 
			"function ietruebody(){\r\n" + 
			"	return (document.compatMode && document.compatMode!=\"BackCompat\")? document.documentElement : document.body;\r\n" + 
			"}\r\n" + 
			"function IsElement(id){\r\n" + 
			"	return document.getElementById(id)!=null ? true : false;\r\n" + 
			"}\r\n" + 
			"</script>\r\n" + 
			"</head>\r\n" + 
			"<body onkeydown=\"keyCodes(event);\">\r\n" + 
			"<div id=\"wrapA\">\r\n" + 
			"\r\n" + 
			"<div id=\"header\">\r\n" + 
			"<div class=\"toptool tar\">\r\n" + 
			"	<span>\r\n" + 
			"	<a href=\"simple/\" target=\"_blank\">无图版</a>\r\n" + 
			"\r\n" + 
			"	| <a href=\"faq.php\">帮助</a>\r\n" + 
			"	| <a href=\"index.php\">论坛首页</a>\r\n" + 
			"	</span>\r\n" + 
			"</div>\r\n" + 
			"<table cellspacing=\"0\" cellpadding=\"0\" align=\"center\" width=\"100%\">\r\n" + 
			"<tr>\r\n" + 
			"	<td class=\"banner\"><a href=\"./\"></a></td>\r\n" + 
			"	<td class=\"banner\" id=\"banner\" align=\"right\"></td>\r\n" + 
			"</tr>\r\n" + 
			"<tr><td align=\"center\" height=\"1\" colspan=\"2\"></td></tr>\r\n" + 
			"</table>\r\n" + 
			"<div id=\"h_guide\" class=\"guide\" colspan=\"2\"><span class=\"s3\">&raquo;</span>\r\n" + 
			"\r\n" + 
			"	您尚未　<a href=\"login.php\">登录</a> &nbsp;<a href=\"register.php\"><b>注册</b></a>\r\n" + 
			"\r\n" + 
			"	| <a href=\"push.php?fid=4\">推荐</a>\r\n" + 
			"	| <a href=\"search.php\">搜索</a>\r\n" + 
			"\r\n" + 
			"</div>\r\n" + 
			"<div id=\"menu_hack\" class=\"menu\" style=\"display:none;\"><table width=\"120\" cellspacing=\"1\" cellpadding=\"5\">\r\n" + 
			"	<tr><th class=\"h\">社区服务</th></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"hack.php?H_name=bank\">银行</a></td></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"hack.php?H_name=invite\">邀请注册</a></td></tr>\r\n" + 
			"\r\n" + 
			"</table></div>\r\n" + 
			"<div id=\"menu_skin\" class=\"menu\" style=\"display:none;\"><table width=\"120\" cellspacing=\"1\" cellpadding=\"5\">\r\n" + 
			"	<tr><th class=\"h\">风格切换</th></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"/bt/thread.php?fid=4&skinco=new3\">new3</a></td></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"/bt/thread.php?fid=4&skinco=wind5\">wind5</a></td></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"/bt/thread.php?fid=4&skinco=wind\">wind</a></td></tr>\r\n" + 
			"\r\n" + 
			"	<tr><td class=\"f_one\"><a href=\"/bt/thread.php?fid=4&skinco=new5\">new5</a></td></tr>\r\n" + 
			"\r\n" + 
			"</table></div>\r\n" + 
			"\r\n" + 
			"</div>\r\n" + 
			"<div id=\"main\">\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<div class=\"t3\" style=\"margin:8px auto\"><table width=\"100%\" cellspacing=\"0\" cellpadding=\"0\" align=\"center\">\r\n" + 
			"	<tr><td>\r\n" + 
			"	<strong class=\"fl w\"><img src=\"image/wind/index/home.gif\" align=\"absmiddle\" /> <a href=\"index.php\">bt下载</a> &raquo; <a href=\"thread.php?fid=4\">亚洲有码区</a> <a target=\"_blank\" href=\"http://www.560555.com/?s=10664\"><font color=red size=5>真钱赌博性感荷官与您相约</font></a></strong>\r\n" + 
			"	<div class=\"fr w\">\r\n" + 
			"\r\n" + 
			"		<a target=\"_blank\" href=\"http://wpa.qq.com/msgrd?v=3&uin=1993267234&site=qq&menu=yes\"><font color=red size=5>纯情美女QQ裸聊[可验证]</font></a>\r\n" + 
			"\r\n" + 
			"		</div>\r\n" + 
			"	</td></tr>\r\n" + 
			"</table></div>\r\n" + 
			"\r\n" + 
			"<!--ads begin-->\r\n" + 
			"\r\n" + 
			"<!--ads end-->\r\n" + 
			"\r\n" + 
			"<div class=\"c\"></div>\r\n" + 
			"\r\n" + 
			"<div class=\"t3\"><table width=\"100%\" align=\"center\" cellspacing=\"0\" cellpadding=\"0\">\r\n" + 
			"	<tr><td align=\"left\" valign=\"middle\"><div class=\"fl\"><div class=\"pages\"><a href=\"/bt/thread.php?fid=4&page=1\" style=\"font-weight:bold\">&laquo;</a><b> 1 </b><a href=\"/bt/thread.php?fid=4&page=2\">2</a><a href=\"/bt/thread.php?fid=4&page=3\">3</a><a href=\"/bt/thread.php?fid=4&page=4\">4</a><a href=\"/bt/thread.php?fid=4&page=5\">5</a><input type=\"text\" size=\"3\" onkeydown=\"javascript: if(event.keyCode==13){ location='thread.php?fid=4&page='+this.value+'';return false;}\"><a href=\"/bt/thread.php?fid=4&page=822\" style=\"font-weight:bold\">&raquo;</a> Pages: ( 1/822 total ) </div></div></td>\r\n" + 
			"	<td style=\"text-align:right\">\r\n" + 
			"\r\n" + 
			"	<a href=\"post.php?fid=4\">发新帖</a>\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	</tr>\r\n" + 
			"</table></div>\r\n" + 
			"\r\n" + 
			"<div id=\"menu_post\" class=\"menu tac f14\" style=\"display:none;\">\r\n" + 
			"	<ul style=\"width:99px\">\r\n" + 
			"\r\n" + 
			"	<li><a href=\"post.php?fid=4\">新  帖</a></li>\r\n" + 
			"\r\n" + 
			"	</ul>\r\n" + 
			"</div>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"<div class=\"t z\" style=\"margin:3px auto\"><table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" id=\"ajaxtable\">\r\n" + 
			"	<tr><th class=\"h\" colspan=\"6\">\r\n" + 
			"		<div class=\"fr\"><a class=\"a2 fn\" href=\"thread.php?fid=4\">全部</a> <a class=\"a2 fn\" href=\"thread.php?fid=4&search=digest\">精华</a>\r\n" + 
			"\r\n" + 
			"		</div>\r\n" + 
			"	<a href=\"thread.php?fid=4\" class=\"fl\">亚洲有码区</a>\r\n" + 
			"		</th>\r\n" + 
			"	</tr>\r\n" + 
			"	<tbody style=\"table-layout:fixed;\"><tr></tr>\r\n" + 
			"	<tr class=\"tr2\">\r\n" + 
			"	<td class=\"tac y-style\">状态</td>\r\n" + 
			"	<td style=\"width:56%\" class=\"tac\">文章</td>\r\n" + 
			"	<td style=\"width:10%\" class=\"y-style\">作者</td>\r\n" + 
			"	<td style=\"width:6%\" class=\"y-style\">回复</td>\r\n" + 
			"	<td style=\"width:6%\" class=\"y-style\">人气</td>\r\n" + 
			"	<td style=\"width:17%\" class=\"y-style\">最后发表</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"middle\" class=\"tr3 t_two\"><td class=\"y-style\"></td><th>&nbsp论坛公告: <h3><a href=\"notice.php?fid=#24\" class=\"black\">爱城备用域名 ： ac168.info</a></h3></th><td class=\"tal y-style\">weilao</td><td colspan=\"2\" class=\"y-style\"><a href=\"notice.php?fid=\">论坛公告</a></td><td class=\"tal y-style\">2013-05-28 13:51</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/0910/371217.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_371217\"> \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/0910/371217.html\" id=\"a_ajax_371217\" target=_blank><font color=red>= = = = = = = = 版规 = = = = = = = =</font></a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=371217&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=371217&page=2&fpage=1\">2</a> <a href=\"/bt/read.php?tid=371217&page=3&fpage=1\">3</a> <a href=\"/bt/read.php?tid=371217&page=4&fpage=1\">4</a> <a href=\"/bt/read.php?tid=371217&page=5&fpage=1\">5</a> .. <a href=\"/bt/read.php?tid=371217&page=96&fpage=1\">96</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">aisex999\r\n" + 
			"		<div class=\"f10\">2009-10-25</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">950</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">370774</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-04-20 02:32 </a><br />by: jiale11149</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr class=\"tr2\"><td colspan=\"6\" class=\"tac\" style=\"border-top:0\">普通主题</td></tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566188.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566188\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566188.html\" id=\"a_ajax_566188\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD] 麻生希 癒著究極超高級性感風俗嬢(STAR_438) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566188&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566188&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">12</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">90</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 22:55 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566187.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566187\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566187.html\" id=\"a_ajax_566187\" target=_blank>[DVD]&nbsp;&nbsp;[SOD] 吉川愛美 19歳、性欲、覚醒濃密SEX (STAR_439) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566187&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566187&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">10</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">84</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 22:57 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566186.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566186\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566186.html\" id=\"a_ajax_566186\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD] 素人超清純美少女 AV Debut 20歳 (SDMT_942) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566186&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566186&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">11</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">95</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:02 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566185.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566185\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566185.html\" id=\"a_ajax_566185\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD]&nbsp;&nbsp;松本明莉 cosplay(STAR_443) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">8</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">69</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:06 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566184.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566184\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566184.html\" id=\"a_ajax_566184\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD] 板垣 唾液粘著發情SEX (STAR_430) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">7</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">62</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:08 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566183.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566183\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566183.html\" id=\"a_ajax_566183\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD] 10名當地美女AV影象大公開 4時間 (SDMT_938) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">6</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">86</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:10 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566182.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566182\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566182.html\" id=\"a_ajax_566182\" target=_blank>[DVD9]&nbsp;&nbsp;[SOD] 若菜亞衣 處女。喪失(SDMT_935) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">6</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">67</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:13 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566181.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566181\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566181.html\" id=\"a_ajax_566181\" target=_blank>[DVD9]&nbsp;&nbsp;[NATURAL HIGH] 人妻奴隷 森ななこ (NHDTA_393) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">8</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">63</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:15 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566180.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566180\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566180.html\" id=\"a_ajax_566180\" target=_blank>[DVD9]&nbsp;&nbsp;[Hunter] 結婚前 近親相姦 (HUNT_706) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">91</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:17 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1306/566179.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566179\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1306/566179.html\" id=\"a_ajax_566179\" target=_blank>[DVD9]&nbsp;&nbsp;[Hunter] 女王，奴隸，超強氣女子校生 (HUNT_705) 【發 售 日】：2013/05/23</a></h3>  \r\n" + 
			"\r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">ken22\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">7</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">76</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 23:20 </a><br />by: lpdzyx</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566176.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566176\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566176.html\" id=\"a_ajax_566176\" target=_blank>ebod279 実話再現 白衣堕天使 小泉真希</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">keycc\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">122</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 20:16 </a><br />by: yangan101</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566175.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566175\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566175.html\" id=\"a_ajax_566175\" target=_blank>ebod278 若妻不倫sex旅 篠原優</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">keycc\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">126</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 20:16 </a><br />by: yangan101</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566174.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566174\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566174.html\" id=\"a_ajax_566174\" target=_blank>ebod277 初撮りH cup 羽生稀</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">keycc\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">111</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 20:16 </a><br />by: yangan101</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566173.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566173\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566173.html\" id=\"a_ajax_566173\" target=_blank>ebod276 巨乳空姐 松下美雪</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">keycc\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">140</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 20:15 </a><br />by: yangan101</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566172.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566172\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566172.html\" id=\"a_ajax_566172\" target=_blank>过于性感的英语老师</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">et7718\r\n" + 
			"		<div class=\"f10\">2013-06-01</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">136</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 20:15 </a><br />by: yangan101</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566167.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566167\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566167.html\" id=\"a_ajax_566167\" target=_blank>[AVI/1.78GB] 私立泡姫商業部女子校生 瀬名あゆむ 青空小夏</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y8p\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">5</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">95</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566165.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566165\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566165.html\" id=\"a_ajax_566165\" target=_blank>[AVI/1001MB] 中出也可以的淫亂美人妻 瀬名あゆむ</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y8p\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">5</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">98</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566164.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566164\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566164.html\" id=\"a_ajax_566164\" target=_blank>[AVI/967MB] 日本痴女乱交派对 9</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y8p\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">7</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">139</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:53 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566163.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566163\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566163.html\" id=\"a_ajax_566163\" target=_blank>[AVI/969MB] 不抽出的14發中出內射 瀬名あゆむ</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y8p\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">6</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">127</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:53 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566159.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566159\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566159.html\" id=\"a_ajax_566159\" target=_blank>近親相姦生中出し!!!! 愛川咲樹 (中文字幕)</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y8p\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">9</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">133</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566158.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566158\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566158.html\" id=\"a_ajax_566158\" target=_blank>[熟女] [OBA-047] 近親相姦 たかし、スケベなお母さんでごめんね…。 竹下千晶</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">cool1328\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">7</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">123</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566157.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566157\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566157.html\" id=\"a_ajax_566157\" target=_blank>[人妻][NATR-217]息子の前で犯されイキまくる人妻 高月和花</a></h3>  \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">cool1328\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">7</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">142</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566153.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566153\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566153.html\" id=\"a_ajax_566153\" target=_blank>(HD1080P)(E-BODY)(ebod00146)再光臨SSS-BODY極限高画質ver.5.0 桜ここみ</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566153&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566153&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">acers\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">11</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">183</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:52 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566132.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566132\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566132.html\" id=\"a_ajax_566132\" target=_blank>[AVI/6.15G]曾经的桃太郎玉女亜紗美合集</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566132&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566132&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y2j\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">13</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">190</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 17:04 </a><br />by: 我行我色</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566129.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566129\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566129.html\" id=\"a_ajax_566129\" target=_blank>[有碼] [FHD/7.13GB] 1日10回射精 蘆名未帆 1080P</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566129&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566129&page=2&fpage=1\">2</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">acers\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">13</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">164</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 14:53 </a><br />by: anyexing</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566122.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566122\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566122.html\" id=\"a_ajax_566122\" target=_blank>[AVI]5-29 新作26連發[各取所需]</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566122&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566122&page=2&fpage=1\">2</a> <a href=\"/bt/read.php?tid=566122&page=3&fpage=1\">3</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">coolkyanyi\r\n" + 
			"		<div class=\"f10\">2013-05-31</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">23</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">309</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 07:40 </a><br />by: bg1370</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566054.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566054\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566054.html\" id=\"a_ajax_566054\" target=_blank>[1388][AVI]5-27 新作28連發</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566054&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566054&page=2&fpage=1\">2</a> <a href=\"/bt/read.php?tid=566054&page=3&fpage=1\">3</a> <a href=\"/bt/read.php?tid=566054&page=4&fpage=1\">4</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">coolkyanyi\r\n" + 
			"		<div class=\"f10\">2013-05-29</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">31</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">507</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 07:41 </a><br />by: bg1370</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566034.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566034\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566034.html\" id=\"a_ajax_566034\" target=_blank>[RMVB/2.27G]中文字幕影片四連發</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566034&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566034&page=2&fpage=1\">2</a> <a href=\"/bt/read.php?tid=566034&page=3&fpage=1\">3</a> <a href=\"/bt/read.php?tid=566034&page=4&fpage=1\">4</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">coolkyanyi\r\n" + 
			"		<div class=\"f10\">2013-05-29</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">35</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">607</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 03:59 </a><br />by: aoxu001</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr align=\"center\" class=\"tr3 t_one\"><td><a title=\"打开新窗口\" href=\"htm_data/4/1305/566005.html\" target=\"_blank\"></a></td><td style=\"text-align:left;padding-left:8px\" id=\"td_566005\"> \r\n" + 
			"\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<h3><a href=\"htm_data/4/1305/566005.html\" id=\"a_ajax_566005\" target=_blank>イケナイマリエ先生のムッチムチ肉感授業 桃華マリエ</a></h3>  \r\n" + 
			"\r\n" + 
			"	 [ <span style=\"font-size:7pt;font-family:verdana;\"> <a href=\"/bt/read.php?tid=566005&page=1&fpage=1\">1</a> <a href=\"/bt/read.php?tid=566005&page=2&fpage=1\">2</a> <a href=\"/bt/read.php?tid=566005&page=3&fpage=1\">3</a></span> ]\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	<td class=\"tal y-style\">y2j\r\n" + 
			"		<div class=\"f10\">2013-05-28</div></td>\r\n" + 
			"	<td class=\"tal f10 y-style\">24</td>\r\n" + 
			"	<td class=\"tal f10 y-style\">485</td>\r\n" + 
			"	<td class=\"tal y-style\"><a class=\"f10\"> 2013-06-01 03:36 </a><br />by: ★堕落之魂★</td>\r\n" + 
			"	</tr>\r\n" + 
			"\r\n" + 
			"	<tr><td colspan=\"6\" class=\"f_one\" style=\"height:8px\"></td></tr>\r\n" + 
			"	</tbody>\r\n" + 
			"</table></div>\r\n" + 
			"\r\n" + 
			"<div class=\"t\"><table style=\"padding:5px; margin-bottom:2px\" class=\"f_two\" cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\">\r\n" + 
			"	<tr>\r\n" + 
			"		<td>\r\n" + 
			"		<form action=\"thread.php?fid=4&page=1\" method=\"post\">\r\n" + 
			"		<select name=\"search\">\r\n" + 
			"			<option value=\"\"></option>\r\n" + 
			"			<option value=\"digest\">本版精华区</option>\r\n" + 
			"			<option value=\"1\">1天内的主题</option>\r\n" + 
			"			<option value=\"2\">2天内的主题</option>\r\n" + 
			"			<option value=\"7\">1星期内的主题</option>\r\n" + 
			"			<option value=\"30\">1个月内的主题</option>\r\n" + 
			"			<option value=\"60\">2个月内的主题</option>\r\n" + 
			"			<option value=\"90\">3个月内的主题</option>\r\n" + 
			"			<option value=\"180\">6个月内的主题</option>\r\n" + 
			"			<option value=\"365\">1年内的主题</option>\r\n" + 
			"		</select>\r\n" + 
			"\r\n" + 
			"		<input class=\"btn\" type=\"button\" value=\"提 交\" onclick=\"this.form.submit();\">\r\n" + 
			"		</form>\r\n" + 
			"		</td>\r\n" + 
			"		<td align=\"right\">\r\n" + 
			"		<form name=\"jump\" method=\"post\">\r\n" + 
			"		<a class=\"abtn f_two\" href=\"profile.php?action=forumright&fid=4\" title=\"查看您在本版块的权限\">版块权限查看</a>\r\n" + 
			"		<a class=\"abtn f_two\" onclick=\"sendmsg('pw_ajax.php?action=readlog','',this.id);\" id=\"readlog\">帖子浏览记录</a>\r\n" + 
			"		<a class=\"abtn f_two\" id=\"threadlog\" onclick=\"sendmsg('pw_ajax.php','action=threadlog',this.id);\">版块浏览记录</a>\r\n" + 
			"		<select onchange=\"Fjump(this.options[this.selectedIndex].value)\">\r\n" + 
			"		<option value=\"\" selected>快速跳至</option>\r\n" + 
			"<option value=\"3\">>> 发片区</option>\r\n" + 
			"<option value=\"16\"> &nbsp;|- 亚洲无码区</option>\r\n" + 
			"<option value=\"4\"> &nbsp;|- 亚洲有码区</option>\r\n" + 
			"<option value=\"5\"> &nbsp;|- 欧美区</option>\r\n" + 
			"<option value=\"18\"> &nbsp;|- 在线影院区</option>\r\n" + 
			"<option value=\"11\"> &nbsp;|- 游戏区</option>\r\n" + 
			"<option value=\"6\"> &nbsp;|- 动漫区</option>\r\n" + 
			"<option value=\"12\"> &nbsp;|- 国产影视剧(非色情)</option>\r\n" + 
			"<option value=\"19\"> &nbsp;|- 3D影视区</option>\r\n" + 
			"<option value=\"13\">>> 贴图区</option>\r\n" + 
			"<option value=\"14\"> &nbsp;|- 亚洲贴图区</option>\r\n" + 
			"<option value=\"15\"> &nbsp;|- 欧美贴图区</option>\r\n" + 
			"<option value=\"7\">>> 技术交流区</option>\r\n" + 
			"<option value=\"8\"> &nbsp;|- 技术交流区</option>\r\n" + 
			"<option value=\"9\"> &nbsp;|- 求片区</option>\r\n" + 
			"<option value=\"10\"> &nbsp;|- 灌水区</option>\r\n" + 
			"\r\n" + 
			"		</select>\r\n" + 
			"		</form>\r\n" + 
			"		</td>\r\n" + 
			"	</tr>\r\n" + 
			"</table></div>\r\n" + 
			"<div class=\"t3\"><table cellspacing=\"0\" cellpadding=\"0\" width=\"100%\" align=\"center\">\r\n" + 
			"	<tr valign=\"top\">\r\n" + 
			"		<td align=\"left\"><div class=\"pages\"><a href=\"/bt/thread.php?fid=4&page=1\" style=\"font-weight:bold\">&laquo;</a><b> 1 </b><a href=\"/bt/thread.php?fid=4&page=2\">2</a><a href=\"/bt/thread.php?fid=4&page=3\">3</a><a href=\"/bt/thread.php?fid=4&page=4\">4</a><a href=\"/bt/thread.php?fid=4&page=5\">5</a><input type=\"text\" size=\"3\" onkeydown=\"javascript: if(event.keyCode==13){ location='thread.php?fid=4&page='+this.value+'';return false;}\"><a href=\"/bt/thread.php?fid=4&page=822\" style=\"font-weight:bold\">&raquo;</a> Pages: ( 1/822 total ) </div></td>\r\n" + 
			"	<td style=\"text-align:right;padding-top:5px\">\r\n" + 
			"	\r\n" + 
			"\r\n" + 
			"	<a href=\"post.php?fid=4\">发新帖</a>\r\n" + 
			"\r\n" + 
			"	</td>\r\n" + 
			"	</tr>\r\n" + 
			"</table></div>\r\n" + 
			"\r\n" + 
			"<center>\r\n" + 
			" 开放主题  热门主题  锁定主题  关闭主题 投票主题  锁定投票\r\n" + 
			"</center><br />\r\n" + 
			"<script language=\"JavaScript\">\r\n" + 
			"var ifcheck = true;\r\n" + 
			"var fid = '4';\r\n" + 
			"function CheckAll(form){\r\n" + 
			"	for(var i=0;i<form.elements.length-12;i++){\r\n" + 
			"		var e = form.elements[i];\r\n" + 
			"		if(e.type=='checkbox') e.checked = ifcheck;\r\n" + 
			"	}\r\n" + 
			"	ifcheck = ifcheck == true ? false : true;\r\n" + 
			"}\r\n" + 
			"function Fjump(value){\r\n" + 
			"	if(value!=''){\r\n" + 
			"		window.location=('http://www.aisex.com/bt/thread.php?fid='+value);\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"function Ajump(value){\r\n" + 
			"	if(value!= ''){\r\n" + 
			"		window.location=('http://www.aisex.com/bt/profile.php?action=show&username='+value);\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"var totalpage = parseInt('822');\r\n" + 
			"var page = parseInt('1');\r\n" + 
			"if(totalpage > 1){\r\n" + 
			"	document.onkeydown=function(e){\r\n" + 
			"		var e = is_ie ? window.event : e;\r\n" + 
			"		var tagname = is_ie ? e.srcElement.tagName : e.target.tagName;\r\n" + 
			"		if(tagname == 'INPUT' || tagname == 'TEXTAREA'){\r\n" + 
			"			return;\r\n" + 
			"		}\r\n" + 
			"		actualCode = e.keyCode ? e.keyCode : e.charCode;\r\n" + 
			"		if(actualCode == 39 && page<totalpage) {\r\n" + 
			"			window.location = 'thread.php?fid=4&search=&page=' + (page+1);\r\n" + 
			"		}\r\n" + 
			"		if(actualCode == 37 && page>1){\r\n" + 
			"			window.location = 'thread.php?fid=4&search=&page=' + (page-1);\r\n" + 
			"		}\r\n" + 
			"	}\r\n" + 
			"}\r\n" + 
			"</script>\r\n" + 
			"<script type=\"text/javascript\" language=\"JavaScript\" src=\"js/pw_ajax.js\"></script>\r\n" + 
			"\r\n" + 
			"\r\n" + 
			"</div>\r\n" + 
			"<div id=\"bottom\"></div><br />\r\n" + 
			"<center class=\"gray\">\r\n" + 
			"<small><span id=\"windspend\"></span> <br />\r\n" + 
			"</small>\r\n" + 
			"</center><br />\r\n" + 
			"<div id=\"footer\">\r\n" + 
			"	<span class=\"f12 fl\"></span><a href=\"\">Contact us</a> | <a href=\"wap/index.php\">Wap</a> | <a href=\"javascript:scroll(0,0)\">Top</a>\r\n" + 
			"\r\n" + 
			"</div>\r\n" + 
			"</div>\r\n" + 
			"</body></html>\r\n" + 
			"<script language=\"JavaScript\" src=\"js/global.js\"></script>\r\n" + 
			"<script language=\"JavaScript\">\r\n" + 
			"var openmenu = {'td_hack' : 'menu_hack','td_skin' : 'menu_skin','td_post' : 'menu_post','td_post1' : 'menu_post'};\r\n" + 
			"read.InitMenu();\r\n" + 
			"</script>\r\n" + 
			"\r\n" + 
			"";

	@Override
	protected void setUp() throws Exception {
		// TODO Auto-generated method stub
	}

	public void testSearchOneKey() throws IOException
	{

		WebPage page=EasyMock.createMock(WebPage.class);
		EasyMock.expect(page.getHtmlContent()).andReturn(html);
		EasyMock.replay(page);		
		
		KeyWordMatcher keyWordMatcher=new KeyWordMatcher();
		keyWordMatcher.addKeyWord("吉川愛美");
		WebPageSearcher s=new WebPageSearcher(page,keyWordMatcher);
		SearchResult sr=s.search();
		assertNotNull(sr);
		Collection<String> links=sr.getKeyWordResult("吉川愛美");
		assertNotNull(links);
		assertTrue(links.contains("htm_data/4/1306/566187.html"));
	}
	
	public void testSearchTwoKey() throws IOException
	{

		WebPage page=EasyMock.createMock(WebPage.class);
		
		EasyMock.expect(page.getHtmlContent()).andReturn(html);
		EasyMock.replay(page);		
		
		KeyWordMatcher keyWordMatcher=new KeyWordMatcher();
		keyWordMatcher.addKeyWord("吉川愛美");
		keyWordMatcher.addKeyWord("若菜亞衣");
		WebPageSearcher s=new WebPageSearcher(page,keyWordMatcher);
		SearchResult sr=s.search();
		assertNotNull(sr);
		Collection<String> links1=sr.getKeyWordResult("吉川愛美");
		assertNotNull(links1);
		assertTrue(links1.contains("htm_data/4/1306/566187.html"));
		
		Collection<String> links2=sr.getKeyWordResult("若菜亞衣");
		assertNotNull(links2);
		assertTrue(links2.contains("htm_data/4/1306/566182.html"));

	}	
	
}
