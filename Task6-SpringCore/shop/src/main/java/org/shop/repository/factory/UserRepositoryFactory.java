package org.shop.repository.factory;

import java.util.ArrayList;
import java.util.List;

import org.shop.data.User;
import org.shop.repository.UserRepository;
import org.shop.repository.map.AbstractMapRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public final class UserRepositoryFactory {
    
    @Bean
    public UserRepository createUserRepository() {
        return new UserMapRepository();
    }
    
    /**
     * 
     * @author Dzmitry_Naskou
     */
    private class UserMapRepository extends AbstractMapRepository<User> implements UserRepository {

        /* (non-Javadoc)
         * @see org.shop.repository.UserRepository#getUserById(java.lang.Long)
         */
        @Override
        public User getUserById(Long id) {
            return get(id);
        }

        /* (non-Javadoc)
         * @see org.shop.repository.UserRepository#createUser(org.shop.data.User)
         */
        @Override
        public Long createUser(User user) {
            return create(user);
        }

        /* (non-Javadoc)
         * @see org.shop.repository.UserRepository#updateUser(org.shop.data.User)
         */
        @Override
        public void updateUser(User user) {
            update(user);
        }

        /* (non-Javadoc)
         * @see org.shop.repository.UserRepository#getUsers()
         */
        @Override
        public List<User> getUsers() {
            return new ArrayList<User>(register.values());
        }
    }
}
