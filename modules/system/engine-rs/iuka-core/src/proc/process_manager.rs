use std::collections::HashMap;
use anyhow::Result;

pub struct ProcessManager {
    processes: HashMap<u32, String>,
}

impl ProcessManager {
    pub fn new() -> Self {
        Self {
            processes: HashMap::new(),
        }
    }

    pub fn spawn(&mut self, command: &str) -> Result<u32> {
        let pid = 100;
        self.processes.insert(pid, command.to_string());
        Ok(pid)
    }

    pub fn kill(&mut self, pid: u32) -> Result<()> {
        self.processes.remove(&pid);
        Ok(())
    }
}
