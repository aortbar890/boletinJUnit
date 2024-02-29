package boletinJUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import boletinJUnit.Account;

class AccountTest {

    private Account account;

    @BeforeEach
    public void init() {
        account = new Account("Ale Ortiz", 123456789, 1000.0f);
    }
    
    @AfterEach
    public void finish() {
    	account = null;
    }


    @Test
    public void testDeposit() {
        account.deposit(500.0f);
        assertEquals(1500.0f, account.getBalance(), 0.001f);

        account.deposit(-100.0f);
        assertEquals(1500.0f, account.getBalance(), 0.001f);
    }

    @Test
    public void testWithdraw() {
//    	He necesitado comprobar si el valor devuelto por el método withdraw() es verdadero o falso. 
//    	Esto se debe a que la deducción de la cantidad y la tarifa se produce antes de validar si 
//    	la transacción es válida
        
        assertTrue(account.withdraw(500.0f, 10.0f));       
       
        assertFalse(account.withdraw(1500.0f, 10.0f));
        
        assertFalse(account.withdraw(500.0f, -10.0f));
        
        assertFalse(account.withdraw(-500.0f, 10.0f));
  
    }

    @Test
    void testAddInterest() {
        
        account.addInterest();
        float balanceEsperado = 1000.0f + (1000.0f * 0.045f);      
        assertEquals(balanceEsperado, account.getBalance(), 0.001);
    }

}