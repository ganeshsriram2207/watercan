package validator;

import com.revature.wp.dao.UserDAO;
import com.revature.wp.exception.ValidatorException;
import com.revature.wp.model.UserDetail;

public class UserValidator {

	public void Insert(UserDAO user) throws ValidatorException {
		if (UserDetail.getName() == null) {
			throw new ValidatorException("Invalid Name");
		}
		if (UserDetail.getPassword() == null) {
			throw new ValidatorException("Invalid Password");
		}
	}

	public void Login(String name, String password) throws ValidatorException {

		if (name == null) {
			throw new ValidatorException("Invalid name");
		}
		if (password == null) {
			throw new ValidatorException("Invalid Password");
		}
	}

}
