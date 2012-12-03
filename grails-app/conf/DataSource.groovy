dataSource {
    pooled = true
    driverClassName = "com.mysql.jdbc.Driver"
    dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
}
hibernate {
    cache.use_second_level_cache = true
    cache.use_query_cache = false
    cache.region.factory_class = 'net.sf.ehcache.hibernate.EhCacheRegionFactory'
}
// environment specific settings
environments {
    development {
        dataSource {
            //dbCreate = "create-drop" // one of 'create', 'create-drop', 'update', 'validate', ''
            url = "jdbc:mysql://localhost/tvguide_dev?useUnicode=yes&characterEncoding=UTF-8"
            username = "tvguideuser"
            password = "sdFTTY789sadf89"
        }
    }
    test {
        dataSource {
            //dbCreate = "update"
            url = "jdbc:mysql://localhost/tvguide_dev?useUnicode=yes&characterEncoding=UTF-8"
            username = "tvguideuser"
            password = "sdFTTY789sadf89"
        }
    }
    production {
        dataSource {
            //dbCreate = "update"
            url = "jdbc:mysql://localhost/tvguide_prod?useUnicode=yes&characterEncoding=UTF-8"
            username = "tvguideuser"
            password = "sdFTTY789sadf89"
            pooled = true
            properties {
               maxActive = -1
               minEvictableIdleTimeMillis=1800000
               timeBetweenEvictionRunsMillis=1800000
               numTestsPerEvictionRun=3
               testOnBorrow=true
               testWhileIdle=true
               testOnReturn=true
               validationQuery="SELECT 1"
            }
        }
    }
}
