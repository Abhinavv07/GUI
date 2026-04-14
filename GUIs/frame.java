import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Advanced GUI Application with Gradient Background and Event Handling
 * Features: Clean architecture, proper component separation, and robust event handling
 */
public class NewFrame extends JFrame {
    private JButton mainButton;
    private JPanel gradientPanel;
    
    public NewFrame() {
        initializeFrame();
        setupGradientPanel();
        setupMainButton();
        finalizeFrame();
    }
    
    /**
     * Initialize frame properties
     */
    private void initializeFrame() {
        setTitle("Advanced GUI Application");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(true);
    }
    
    /**
     * Create and setup the gradient background panel
     */
    private void setupGradientPanel() {
        gradientPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(255, 100, 100),
                    getWidth(), getHeight(), new Color(100, 150, 255)
                );
                g2d.setPaint(gradient);
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        gradientPanel.setLayout(new BorderLayout());
        add(gradientPanel);
    }
    
    /**
     * Setup the main interactive button
     */
    private void setupMainButton() {
        mainButton = new JButton("CLICK ME");
        mainButton.setFont(new Font("Arial", Font.BOLD, 16));
        mainButton.setBackground(new Color(0, 100, 200));
        mainButton.setForeground(Color.WHITE);
        mainButton.setFocusPainted(false);
        mainButton.addActionListener(new MainButtonListener());
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false);
        buttonPanel.add(mainButton);
        gradientPanel.add(buttonPanel, BorderLayout.CENTER);
    }
    
    /**
     * Finalize frame display
     */
    private void finalizeFrame() {
        setVisible(true);
    }
    
    /**
     * Inner class for main button action handling
     */
    private class MainButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            createDetailWindow();
        }
    }
    
    /**
     * Create a new detail window when button is clicked
     */
    private void createDetailWindow() {
        JFrame detailFrame = new JFrame("Detail Window");
        detailFrame.setSize(400, 300);
        detailFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        detailFrame.setLocationRelativeTo(null);
        
        JLabel detailLabel = createStyledLabel();
        detailFrame.add(detailLabel);
        detailFrame.setVisible(true);
    }
    
    /**
     * Create a styled label with custom formatting
     */
    private JLabel createStyledLabel() {
        JLabel label = new JLabel("Welcome to Advanced GUI!");
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);
        label.setForeground(new Color(0, 255, 0));
        label.setFont(new Font("Lucida Console", Font.BOLD, 18));
        label.setOpaque(true);
        label.setBackground(Color.BLACK);
        return label;
    }
}

/**
 * Main entry point for the application
 */
public class frame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewFrame());
    }
}