use tokio::sync::mpsc;

pub struct IoBridge {
    tx: mpsc::Sender<Vec<u8>>,
    rx: mpsc::Receiver<Vec<u8>>,
}

impl IoBridge {
    pub fn new(tx: mpsc::Sender<Vec<u8>>, rx: mpsc::Receiver<Vec<u8>>) -> Self {
        Self { tx, rx }
    }

    pub async fn write(&self, data: Vec<u8>) {
        let _ = self.tx.send(data).await;
    }
}
