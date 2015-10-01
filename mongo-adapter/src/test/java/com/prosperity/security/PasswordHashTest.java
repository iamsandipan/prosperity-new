package com.prosperity.security;

import static org.junit.Assert.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PasswordHashTest {

	PasswordHash passwordHash;

	@Before
	public void setUp() throws Exception {
		passwordHash = new PasswordHash();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPassword() {
		try {
			// Print out 10 hashes
			for (int i = 0; i < 10; i++) {
				System.out.println(PasswordHash.createHash("p\r\nassw0Rd!"));
			}
			// Test password validation
			boolean failure = false;
			System.out.println("Running tests...");
			failure = testHash(failure);
			if (failure) {
				System.out.println("TESTS FAILED!");
			} else {
				System.out.println("TESTS PASSED!");
			}
		} catch (Exception ex) {
			System.out.println("ERROR: " + ex);
		}
	}

	@Test
	public void testSamePassword() {
//		try {
//			// Print out 10 hashes
//			String hash = PasswordHash.createHash("p\r\nassw0Rd!");
//			String hash1 = PasswordHash.createHash("p\r\nassw0Rd!");
//			assertEquals(hash, hash1);
//			// Test password validation
//			
//		} catch (Exception ex) {
//			System.out.println("ERROR: " + ex);
//		}
	}
	
	private boolean testHash(boolean failure) throws NoSuchAlgorithmException, InvalidKeySpecException {
		for (int i = 0; i < 100; i++) {
			String password = "" + i;
			String hash = passwordHash.createHash(password);
			String secondHash = passwordHash.createHash(password);
			if (hash.equals(secondHash)) {
				System.out.println("FAILURE: TWO HASHES ARE EQUAL!");
				failure = true;
			}
			String wrongPassword = "" + (i + 1);
			if (passwordHash.validatePassword(wrongPassword, hash)) {
				System.out.println("FAILURE: WRONG PASSWORD ACCEPTED!");
				failure = true;
			}
			if (!passwordHash.validatePassword(password, hash)) {
				System.out.println("FAILURE: GOOD PASSWORD NOT ACCEPTED!");
				failure = true;
			}
		}
		return failure;
	}
}
