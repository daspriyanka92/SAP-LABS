package com.comCast.ObjectRepositorylib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignUp {
	
@FindBy(xpath="//div[text()='Sign up']")
private WebElement SignUp;

@FindBy(id="firstName")
private WebElement firstName;

@FindBy(id="lastName")
private WebElement lastName;

@FindBy(name="mail")
private WebElement email;
	
@FindBy(name="newPasswordInput")
private WebElement password;

@FindBy(xpath="div/button[text()='Register']")
private WebElement Register;

@FindBy(id="retypeNewPasswordInput")
private WebElement reenterpassword;

@FindBy(id="pdAccept")
private WebElement checkbox1;

@FindBy(id="touAccept")
private WebElement checkbox2;

public WebElement getfirstName() {
	return firstName;
}
public WebElement getlastName() {
	return lastName;
}
public WebElement getPassword() {
	return password;
}
public WebElement getReenterPassword() {
	return reenterpassword;
}

public WebElement getRegisterBtn() {
	return Register;
}
public void signupNRegister(String FirstName,String LastName,String Password) {
	SignUp.click();
	firstName.sendKeys(FirstName);
	lastName.sendKeys(LastName);
	password.sendKeys(Password);
	reenterpassword.sendKeys(Password);
	checkbox1.click();
	checkbox2.click();
	Register.click();
}
}


