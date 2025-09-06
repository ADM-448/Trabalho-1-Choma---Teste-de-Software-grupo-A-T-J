from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC
import time
from selenium.common.exceptions import TimeoutException

print("Site 1")
driver = webdriver.Chrome()
driver.get("https://www.saucedemo.com/")

wait = WebDriverWait(driver, 10)

# Preenche login
driver.find_element(By.ID, "user-name").send_keys("standard_user")
driver.find_element(By.ID, "password").send_keys("secret_sauce")
driver.find_element(By.ID, "login-button").click()

# Valida login
assert wait.until(EC.presence_of_element_located((By.ID, "inventory_container")))

print("Login realizado com sucesso!")
driver.quit()

print("Site 2")
driver = webdriver.Chrome()
driver.get("https://the-internet.herokuapp.com/login")

wait = WebDriverWait(driver, 10)

# Preenche login
driver.find_element(By.ID, "username").send_keys("tomsmith")
driver.find_element(By.ID, "password").send_keys("SuperSecretPassword!")
driver.find_element(By.XPATH, "//*[@class='fa fa-2x fa-sign-in']").click()
time.sleep(3)

#try para tirar o pop-up se mudar senha, caso ele aparecer
try:
    # Tenta encontrar e aceitar o alerta em até 5 segundos
    WebDriverWait(driver, 5).until(EC.alert_is_present())
    alerta = driver.switch_to.alert
    alerta.accept()
    print("Alerta de 'mudar senha' foi encontrado e aceito.")
except TimeoutException:
    # Se o alerta não aparecer, o 'except' é ativado, mas não quebra o código
    print("Nenhum alerta encontrado, continuando a execução.")
# Valida login
assert wait.until(EC.presence_of_element_located((By.XPATH, "//*[@class='button secondary radius']")))

print("Login realizado com sucesso!")
driver.quit()

print("Site 3")
driver = webdriver.Chrome()
driver.get("https://practicetestautomation.com/practice-test-login/")

wait = WebDriverWait(driver, 10)

# Preenche login
driver.find_element(By.ID, "username").send_keys("student")
driver.find_element(By.ID, "password").send_keys("Password123")
driver.find_element(By.ID, "submit").click()

# Valida login
# Encontra o link cujo texto é exatamente "Log out"
logout_button = driver.find_element(By.LINK_TEXT, "Log out")
logout_button.click()
print("Login realizado com sucesso!")
driver.quit()

print("Site 4")
driver = webdriver.Chrome()
driver.get("https://opensource-demo.orangehrmlive.com/")

wait = WebDriverWait(driver, 10)

# Use a espera para encontrar o campo username e garantir que ele esteja visível
username_field = wait.until(EC.visibility_of_element_located((By.NAME, "username")))
username_field.send_keys("Admin")

# Faça o mesmo para o campo password
password_field = wait.until(EC.visibility_of_element_located((By.NAME, "password")))
password_field.send_keys("admin123")

# Espere o botão de login estar clicável
login_button = wait.until(EC.element_to_be_clickable((By.XPATH, "//*[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")))
login_button.click()

# Espere o menu dropdown do usuário estar clicável
user_dropdown = wait.until(EC.element_to_be_clickable((By.XPATH, "//*[@class='oxd-userdropdown-name']")))
user_dropdown.click()

# Espere o link de Logout estar clicável
logout_link = wait.until(EC.element_to_be_clickable((By.LINK_TEXT, "Logout")))
logout_link.click()
print("Login realizado com sucesso!")
driver.quit()
