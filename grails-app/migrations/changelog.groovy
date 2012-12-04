databaseChangeLog = {

	changeSet(author: "H1net (generated)", id: "1354612458814-1") {
		createTable(tableName: "role") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "rolePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "authority", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-2") {
		createTable(tableName: "tvepisode") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tvepisodePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "air_date", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "episode", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "is_special", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "number", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "production_code", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "season", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "show_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "status", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "tvrage", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "update_flag", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-3") {
		createTable(tableName: "tvepisode_download") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tvepisode_dowPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "episode_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-4") {
		createTable(tableName: "tvshow") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tvshowPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "country", type: "varchar(255)")

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "directory", type: "varchar(255)")

			column(name: "end_date", type: "varchar(255)")

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "network", type: "varchar(255)")

			column(name: "number_of_episodes", type: "varchar(255)")

			column(name: "run_time", type: "varchar(255)")

			column(name: "start_date", type: "varchar(255)")

			column(name: "status", type: "integer") {
				constraints(nullable: "false")
			}

			column(name: "title", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "tvrage", type: "varchar(255)")

			column(name: "update_flag", type: "bit") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-5") {
		createTable(tableName: "tvshow_watcher") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "tvshow_watchePK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "date_created", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "last_updated", type: "datetime") {
				constraints(nullable: "false")
			}

			column(name: "show_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-6") {
		createTable(tableName: "user") {
			column(autoIncrement: "true", name: "id", type: "bigint") {
				constraints(nullable: "false", primaryKey: "true", primaryKeyName: "userPK")
			}

			column(name: "version", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "account_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "account_locked", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "enabled", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "first_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "last_name", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password", type: "varchar(255)") {
				constraints(nullable: "false")
			}

			column(name: "password_expired", type: "bit") {
				constraints(nullable: "false")
			}

			column(name: "username", type: "varchar(255)") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-7") {
		createTable(tableName: "user_role") {
			column(name: "role_id", type: "bigint") {
				constraints(nullable: "false")
			}

			column(name: "user_id", type: "bigint") {
				constraints(nullable: "false")
			}
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-8") {
		addPrimaryKey(columnNames: "role_id, user_id", constraintName: "user_rolePK", tableName: "user_role")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-9") {
		addForeignKeyConstraint(baseColumnNames: "show_id", baseTableName: "tvepisode", constraintName: "FKB4BEB939176654F0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tvshow", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-10") {
		addForeignKeyConstraint(baseColumnNames: "episode_id", baseTableName: "tvepisode_download", constraintName: "FK929B90CE547963C4", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tvepisode", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-11") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "tvepisode_download", constraintName: "FK929B90CE164C1DAE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-12") {
		addForeignKeyConstraint(baseColumnNames: "show_id", baseTableName: "tvshow_watcher", constraintName: "FKE1EE69FC176654F0", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "tvshow", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-13") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "tvshow_watcher", constraintName: "FKE1EE69FC164C1DAE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-14") {
		addForeignKeyConstraint(baseColumnNames: "role_id", baseTableName: "user_role", constraintName: "FK143BF46A712159CE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "role", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-15") {
		addForeignKeyConstraint(baseColumnNames: "user_id", baseTableName: "user_role", constraintName: "FK143BF46A164C1DAE", deferrable: "false", initiallyDeferred: "false", referencedColumnNames: "id", referencedTableName: "user", referencesUniqueColumn: "false")
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-16") {
		createIndex(indexName: "authority_unique_1354612458627", tableName: "role", unique: "true") {
			column(name: "authority")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-17") {
		createIndex(indexName: "FKB4BEB939176654F0", tableName: "tvepisode") {
			column(name: "show_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-18") {
		createIndex(indexName: "airDate_idx", tableName: "tvepisode") {
			column(name: "air_date")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-19") {
		createIndex(indexName: "dateCreated_idx", tableName: "tvepisode") {
			column(name: "date_created")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-20") {
		createIndex(indexName: "episode_idx", tableName: "tvepisode") {
			column(name: "episode")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-21") {
		createIndex(indexName: "number_idx", tableName: "tvepisode") {
			column(name: "number")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-22") {
		createIndex(indexName: "season_idx", tableName: "tvepisode") {
			column(name: "season")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-23") {
		createIndex(indexName: "show_idx", tableName: "tvepisode") {
			column(name: "show_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-24") {
		createIndex(indexName: "updateFlag", tableName: "tvepisode") {
			column(name: "update_flag")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-25") {
		createIndex(indexName: "FK929B90CE164C1DAE", tableName: "tvepisode_download") {
			column(name: "user_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-26") {
		createIndex(indexName: "FK929B90CE547963C4", tableName: "tvepisode_download") {
			column(name: "episode_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-27") {
		createIndex(indexName: "dateCreated_idx", tableName: "tvshow") {
			column(name: "date_created")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-28") {
		createIndex(indexName: "directory_idx", tableName: "tvshow") {
			column(name: "directory")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-29") {
		createIndex(indexName: "title_idx", tableName: "tvshow") {
			column(name: "title")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-30") {
		createIndex(indexName: "updateFlag", tableName: "tvshow") {
			column(name: "update_flag")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-31") {
		createIndex(indexName: "FKE1EE69FC164C1DAE", tableName: "tvshow_watcher") {
			column(name: "user_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-32") {
		createIndex(indexName: "FKE1EE69FC176654F0", tableName: "tvshow_watcher") {
			column(name: "show_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-33") {
		createIndex(indexName: "username_unique_1354612458668", tableName: "user", unique: "true") {
			column(name: "username")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-34") {
		createIndex(indexName: "FK143BF46A164C1DAE", tableName: "user_role") {
			column(name: "user_id")
		}
	}

	changeSet(author: "H1net (generated)", id: "1354612458814-35") {
		createIndex(indexName: "FK143BF46A712159CE", tableName: "user_role") {
			column(name: "role_id")
		}
	}
}
