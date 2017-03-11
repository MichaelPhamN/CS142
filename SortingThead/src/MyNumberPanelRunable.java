
public class MyNumberPanelRunable implements Runnable {

	private MyNumberPanel numberPanel=null;
	private boolean isFinished=false;
	public MyNumberPanelRunable(MyNumberPanel pn)
	{
		this.numberPanel=pn;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			while(!Thread.currentThread().isInterrupted() && isFinished==false)
				{
					switch(MyNumberFrame.SortType)
					{
					case BUBBLE_SORT:
						numberPanel.doBubbleSort();
						break;
					case SELECTION_SORT:
						numberPanel.doSelectionSort();
						break;
					case INSERTION_SORT:
						numberPanel.doInsertionSort();
						break;
					case QUICK_SORT:
						numberPanel.doQuickSort();
						break;
					}
					
					Thread.sleep(1000);
					isFinished=numberPanel.getIsFinished();
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
