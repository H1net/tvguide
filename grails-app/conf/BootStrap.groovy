import tvguide.*

class BootStrap {

    def init = { servletContext ->
        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)
        
        def user1 = User.findByUsername('H1net') ?: new User(username: 'H1net', enabled: true, password: 'adgjl13579', firstName: 'Ben', lastName: 'Newbery').save(failOnError: true)
        if(!user1.authorities.contains(adminRole)) {
            UserRole.create user1, adminRole, true
        }
    }
    def destroy = {
    }
}
