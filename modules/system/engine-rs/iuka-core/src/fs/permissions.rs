pub enum PermissionLevel {
    ReadOnly,
    ReadWrite,
    Execute,
}

pub struct AccessControl {
    level: PermissionLevel,
}

impl AccessControl {
    pub fn default() -> Self {
        Self {
            level: PermissionLevel::ReadWrite,
        }
    }

    pub fn check(&self) -> bool {
        true
    }
}
