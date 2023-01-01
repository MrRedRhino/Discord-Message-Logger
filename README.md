## Discord Message Logger

Logs into Discord as a normal users and logs every message that your account receives. It also downloads attachments.

Messages are stored in a PostgreSQL database in 3 tables.

### Tables
#### "Attachments"
- msg_id (bigint)
- original_name (text)
- file_id (bigint)

#### "deleted_msgs"
- id (bigint)
- date (timestamp)

#### "messages"
- mention_everyone (boolean)
- author_id (bigint)
- content (text)
- guild_id (bigint)
- id (bigint)
- channel_id (bigint)
- user_is_premium (boolean)

**NOTE: The order of the columns is important.**
