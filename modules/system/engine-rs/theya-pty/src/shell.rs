use std::process::Command;

pub struct Shell {
    command: Command,
}

impl Shell {
    pub fn new(cmd: &str) -> Self {
        Self {
            command: Command::new(cmd),
        }
    }
}
