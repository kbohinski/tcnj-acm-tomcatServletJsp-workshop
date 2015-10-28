<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
	URL fileUrl = new URL("https://raw.githubusercontent.com/kbohinski/Michael-Scott-API/master/QuoteData.txt");
	Random rng = new Random();
	ArrayList<String> quotes = new ArrayList<String>();
	for (Scanner in = new Scanner(fileUrl.openStream()); in
			.hasNext();) {
		quotes.add(in.nextLine());
	}
	int r = rng.nextInt(quotes.size());
%>
{ "quote": "" <% out.print(quotes.get(r)); %> " - Michael Scott" }
</body>
</html>