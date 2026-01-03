pub mod fs;
pub mod proc;

use crate::proc::process_manager::ProcessManager;
use std::sync::Arc;
use tokio::sync::Mutex;

pub struct IukaEngine {
    process_manager: Arc<Mutex<ProcessManager>>,
}

impl IukaEngine {
    pub fn new() -> Self {
        Self {
            process_manager: Arc::new(Mutex::new(ProcessManager::new())),
        }
    }

    pub async fn initialize(&self) -> Result<(), anyhow::Error> {
        Ok(())
    }
}
