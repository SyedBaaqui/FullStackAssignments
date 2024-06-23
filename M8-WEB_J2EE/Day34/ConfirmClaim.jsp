<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.ClaimInsurance.ClaimBean" %>
<!DOCTYPE html>
<html>
<head>
    <title>Claim Confirmation</title>
</head>
<body>
    <h1>Claim Confirmation</h1>
    <p>Policy Number: ${claim.policyNumber}</p>
    <p>Claim Amount: ${claim.claimAmount}</p>
    <p>Description: ${claim.description}</p>
    <p>Your claim has been submitted successfully!</p>
</body>
</html>