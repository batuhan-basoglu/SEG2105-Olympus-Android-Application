package com.uottawa.olympus.olympusservices;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceProviderTest {

    ServiceProvider serviceprovider = new ServiceProvider("John123", "1234567890", "John", "Doe");

    @Test
    public void testServiceProvider() {
        assertEquals( "John123", serviceprovider.getUsername() );
        assertEquals( "1234567890", serviceprovider.getPassword() );
        assertEquals( "John", serviceprovider.getFirstname() );
        assertEquals( "Doe", serviceprovider.getLastname() );
        assertEquals( "ServiceProvider", serviceprovider.getRole() );
        serviceprovider.setUsername( "username" );
        serviceprovider.setPassword( "password" );
        serviceprovider.setFirstname( "firstname" );
        serviceprovider.setLastname( "lastname" );
        assertNotEquals("John123", serviceprovider.getUsername());
        assertNotEquals("1234567890", serviceprovider.getPassword());
        assertNotEquals("John", serviceprovider.getFirstname());
        assertNotEquals("Doe", serviceprovider.getLastname());
    }

    @Test
    public void addServiceTest() {
        serviceprovider.addService( new Service( "KitchenCleaner", 50 ) );
        serviceprovider.addService( new Service( "FrenchMaid", 250 ) );
        serviceprovider.addService( new Service( "FrenchMaid", 250 ) );
        serviceprovider.addService( new Service( "SecretService", 150 ) );
        serviceprovider.addService( new Service( "SecretService", 150 ) );
        int numOfServices = serviceprovider.getServices().size();
        assertEquals( 3, numOfServices );
    }

}