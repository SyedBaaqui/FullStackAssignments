<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Submit Claim</title>
</head>
<body>
    <h1>Submit Insurance Claim</h1>
    <form action="submitClaim" method="post">
        <label for="policyNumber">Policy Number:</label>
        <input type="text" id="policyNumber" name="policyNumber" required><br>
       
        <label for="claimAmount">Claim Amount:</label>
        <input type="text" id="claimAmount" name="claimAmount" required><br>
       
        <label for="description">Description:</label>
        <textarea id="description" name="description" required></textarea><br>
       
        <input type="submit" value="Submit">
    </form>
</body>
</html>
