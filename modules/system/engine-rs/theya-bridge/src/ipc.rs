pub enum IpcMessage {
    Input(Vec<u8>),
    Output(Vec<u8>),
    Resize(u16, u16),
}

pub trait IpcChannel {
    fn send(&self, msg: IpcMessage);
    fn recv(&self) -> Option<IpcMessage>;
}
