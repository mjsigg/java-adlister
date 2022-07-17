<%--
  Created by IntelliJ IDEA.
  User: michaelsigg
  Date: 7/15/22
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pizza Order Form</title>
</head>
<body>

<%--//pizza form--%>
<form action="/pizza-order" method="POST" name="everything">

<%--    ///select crust--%>
    <label for="crust">Pick a crust:</label>
    <select name="everything" id="crust">
        <option value="Thin">Thin</option>
        <option value="shouldBeThin">shouldBeThin</option>
        <option value="notThinButShouldBe">!notThinButShouldBe</option>
        <option value="notThinSoNotAPizza">!notThinSoNotAPizza</option>
    </select>

<%--    // sauce--%>
    <label for="sauce">Pick a sauce:</label>
    <select name="everything" id="sauce">
        <option value="noSauce">No Sauce</option>
        <option value="someSauce">Some Sauce</option>
        <option value="tooMuchSauce">Too Much Sauce</option>
        <option value="lostInSauce">Saucy</option>
    </select>

<%--    // size--%>
    <label for="size">Pick a size:</label>
    <select name="everything" id="size">
        <option value="kid">Kid Size</option>
        <option value="halfSteppin">Half Step</option>
        <option value="wholeThing">All there</option>
        <option value="attaBoy">Atta boy</option>
    </select>

<%--    // toppings--%>

    <input type="checkbox" id="pepperoni" name="everything" value="pepperoni">
    <label for="pepperoni"> Pepperoni</label><br>

    <input type="checkbox" id="sausage" name="everything" value="sausage">
    <label for="sausage"> Sausage</label><br>

    <input type="checkbox" id="allTheVeg" name="everything" value="allTheVeg">
    <label for="allTheVeg"> All the veg</label><br>

<%--    ///address--%>
    <label for="address"></label><br>
    <input type="text" id="address" name="everything" placeholder="Enter address.."><br>

    <button value="go"> Send it</button>

</form>

</body>
</html>
