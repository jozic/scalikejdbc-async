/*
 * Copyright 2013 Kazuhiro Sera
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package scalikejdbc.async.internal.mysql

import scalikejdbc.async._, internal._

/**
 * MySQL Single Connection
 */
private[scalikejdbc] case class SingleAsyncMySQLConnection(url: String, user: String, private val password: String)
    extends AsyncConnectionCommonImpl
    with MySQLConnectionImpl
    with MauricioConfiguration {

  private[scalikejdbc] val underlying: com.github.mauricio.async.db.Connection = {
    new com.github.mauricio.async.db.mysql.MySQLConnection(configuration(url, user, password))
  }

}

