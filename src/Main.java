/*
* Remove - extends Application |  Niv 13.09.18 [ public class Main  { ]
* */
public class Main  {
	public static void main(String[] args){
		try{
			/* Member */
			////////////
			// Register Employee
			Member memberToRegister   = new Member( "Niv", "Noiman", "Rishon Lezzion, Maccabi Zahir, 6", "0524011331" , "niv@gmail.com" );
			Member employeeToRegister = new Employee( memberToRegister );
			if( employeeToRegister.register( "111111111" ) != null ){
				System.out.println("Employee Successfully Registered ");
			} else{
				System.out.println("Register Failed: Member Already Registered");
			}

			// Register Customer
			Member memberToRegister2   = new Member( "Niv", "Noiman", "Rishon Lezzion, Maccabi Zahir, 6", "0524011331" , "niv2@gmail.com" );
			Member customerToRegister  = new Customer( memberToRegister2 );
			if( customerToRegister.register( "111111111" ) != null ){
				System.out.println("Customer Successfully Registered ");
			} else{
				System.out.println("Register Failed: Member Already Registered");
			}

			// Login Employee
			EmployeeHelper EmployeeHelper = new EmployeeHelper();
			Employee employee             =  EmployeeHelper.login( new Email( "niv@gmail.com" ) , "111111111" );
			if( employee.isLoggedIn() ){
				System.out.println( employee.getFirstName() + "[" + employee.getId() + "] Is Logged IN AS Employee !");
			} else{
				System.out.println( "Login Failed: Email Or Password Is Incorrect ");
			}

			// Login Customer
			CustomerHelper CustomerHelper = new CustomerHelper();
			Customer customer             =  CustomerHelper.login( new Email( "niv2@gmail.com" ) , "111111111" );
			if( customer.isLoggedIn() ){
				System.out.println( customer.getFirstName() + "[" + customer.getId() + "] Is Logged IN AS Customer !");
			} else{
				System.out.println( "Login Failed: Email Or Password Is Incorrect ");
			}

			/* Product */
			/////////////
			// Create New Product
			ProductHelper ProductHelper = new ProductHelper();
			Product productToInsert     = new Product( "11" , "Jeans" , "trousers" , "M" , 500, 20 );
			Product newProduct          = ProductHelper.insert( productToInsert );
			if( newProduct != null ){
				System.out.println("Product Created Successfully");
			} else{
				System.out.println("Product Creation Failed: Product Already Inserted");
			}
			// Print All Products We Have
			ProductHelper.printAllProducts();

			// Employee - Sell Product To Customer
			employee.sell( productToInsert , customer.getId() );

		} catch(Exception e){
			System.out.println( e.getMessage() );
		}
	}
}
